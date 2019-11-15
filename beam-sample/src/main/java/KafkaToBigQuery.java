import com.fasterxml.jackson.databind.ObjectMapper;
import entity.UserProfileMessage;
import entity.UserProfilePayload;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.io.kafka.KafkaIO;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Values;
import org.apache.beam.sdk.values.PCollection;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.SecurityUtils;

import java.io.IOException;
import java.util.Collections;

/** The type Kafka to big query. */
public class KafkaToBigQuery {
  private static final Logger LOG = LoggerFactory.getLogger(KafkaToBigQuery.class);

  public static final String DECRYPT_TOKEN = "abc";

  /** The type Parse json string to user profile message. */
  static class parseJSONStringToUserProfileMessage extends DoFn<String, UserProfileMessage> {
    /**
     * Process element.
     *
     * @param jsonString the json string
     * @param message the message
     */
    @ProcessElement
    public void processElement(
        @Element String jsonString, OutputReceiver<UserProfileMessage> message) {
      ObjectMapper mapper = new ObjectMapper();

      UserProfileMessage obj = null;
      try {
        obj = mapper.readValue(jsonString, UserProfileMessage.class);
      } catch (IOException e) {
        e.printStackTrace();
      }
      message.output(obj);
    }
  }

  /** The type Decrypt user profile payload. */
  static class decryptUserProfilePayload extends DoFn<UserProfileMessage, UserProfilePayload> {
    /**
     * Process element.
     *
     * @param userProfileMessage the user profile message
     * @param payload the payload
     */
    @ProcessElement
    public void processElement(
        @Element UserProfileMessage userProfileMessage,
        OutputReceiver<UserProfilePayload> payload) {
      ObjectMapper mapper = new ObjectMapper();
      byte[] bytes = ArrayUtils.toPrimitive(userProfileMessage.getPayload());
      try {
        System.out.println(SecurityUtils.decrypt(bytes, DECRYPT_TOKEN));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /** The interface Options. */
  public interface Options extends PipelineOptions {
    /**
     * Gets kafka server.
     *
     * @return the kafka server
     */
    @Description("Kafka Bootstrap Servers")
    @Default.String("localhost:9092")
    String getKafkaServer();

    /**
     * Sets kafka server.
     *
     * @param value the value
     */
    void setKafkaServer(String value);

    /**
     * Gets input topic.
     *
     * @return the input topic
     */
    @Description("Kafka Input Topic Name")
    @Default.String("user.profile")
    String getInputTopic();

    /**
     * Sets input topic.
     *
     * @param value the value
     */
    void setInputTopic(String value);

    /**
     * Gets duration.
     *
     * @return the duration
     */
    @Description("Pipeline duration to wait until finish in seconds")
    @Default.Long(-1)
    Long getDuration();

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    void setDuration(Long duration);
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException the io exception
   */
  public static void main(String[] args) throws IOException {
    Options options = PipelineOptionsFactory.fromArgs(args).withValidation().as(Options.class);
    LOG.info(options.toString());
    System.out.println(options.toString());
    options.setDuration(1000000L);
    Pipeline pipeline = Pipeline.create(options);

    // now we connect to the queue and process every event
    PCollection<String> jsonString =
        pipeline
            .apply(
                "ReadFromKafka",
                KafkaIO.<String, String>read()
                    .withKeyDeserializer(StringDeserializer.class)
                    .withValueDeserializer(StringDeserializer.class)
                    .withBootstrapServers(options.getKafkaServer())
                    .withTopics(Collections.singletonList(options.getInputTopic()))
                    .withoutMetadata())
            .apply("ExtractPayload", Values.create());
    PCollection<UserProfileMessage> userProfileMessage =
        jsonString.apply(
            "ParseJSONStringToUserProfileMessage",
            ParDo.of(new parseJSONStringToUserProfileMessage()));
    PCollection<UserProfilePayload> userProfilePayload =
        userProfileMessage.apply(
            "DecryptUserProfilePayload", ParDo.of(new decryptUserProfilePayload()));

    PipelineResult pipelineResult = pipeline.run();
    pipelineResult.waitUntilFinish(Duration.standardSeconds(options.getDuration()));
    PipelineResult result = pipeline.run();
    result.waitUntilFinish(Duration.standardSeconds(options.getDuration()));
  }
}

package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class UserProfileMessage extends BaseEntity {
  @JsonProperty("id")
  private String id;

  @JsonProperty("request_id")
  private String requestId;

  @JsonProperty("ref_event_id")
  private String RefEventId;

  @JsonProperty("event")
  private String event;

  @JsonProperty("service_code")
  private String serviceCode;

  @JsonProperty("timestamp")
  private Long timestamp;

  @JsonProperty("user_id")
  private String userId;

  @JsonProperty("payload_id")
  private String payloadId;

  @JsonProperty("payload_encryption_algorithm")
  private String payloadEncryptionAlgorithm;

  @JsonProperty("payload")
  private Byte[] payload;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getRefEventId() {
    return RefEventId;
  }

  public void setRefEventId(String refEventId) {
    RefEventId = refEventId;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public String getServiceCode() {
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    this.serviceCode = serviceCode;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPayloadId() {
    return payloadId;
  }

  public void setPayloadId(String payloadId) {
    this.payloadId = payloadId;
  }

  public String getPayloadEncryptionAlgorithm() {
    return payloadEncryptionAlgorithm;
  }

  public void setPayloadEncryptionAlgorithm(String payloadEncryptionAlgorithm) {
    this.payloadEncryptionAlgorithm = payloadEncryptionAlgorithm;
  }

  public Byte[] getPayload() {
    return payload;
  }

  public void setPayload(Byte[] payload) {
    this.payload = payload;
  }

  public UserProfileMessage() {}

  @Override
  public String toString() {
    return "UserProfileMessage{"
        + "id='"
        + id
        + '\''
        + ", requestId='"
        + requestId
        + '\''
        + ", RefEventId='"
        + RefEventId
        + '\''
        + ", event='"
        + event
        + '\''
        + ", serviceCode='"
        + serviceCode
        + '\''
        + ", timestamp="
        + timestamp
        + ", userId='"
        + userId
        + '\''
        + ", payloadId='"
        + payloadId
        + '\''
        + ", payloadEncryptionAlgorithm='"
        + payloadEncryptionAlgorithm
        + '\''
        + ", payload="
        + Arrays.toString(payload)
        + '}';
  }
}

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utils.SecurityUtils;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SecurityUtilsTest {

  @Test
  public void testSecurityUtils() throws Exception {
    String input = "must decrypt";
    String token = "cuibap";
    byte[] encrypted = SecurityUtils.encrypt(input.getBytes(), token);
    byte[] decrypted = SecurityUtils.decrypt(encrypted, token);
    assertEquals(input, decrypted);
  }
}

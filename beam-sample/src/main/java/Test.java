import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import utils.SecurityUtils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;

public class Test {

  public static void main(String[] args) throws Exception {

    Security.addProvider(new BouncyCastleProvider());
    String token = "abc";
    String input =
        "3ryJOULBp0C1U7xsSJKed4BUIOXslxTF9WDRnnVuqDbSAPUuoXWxptTFsTRdofN/h7cdzO3TGjXmV1oIFwguWW1ydmd+YgmLkbjtYkWboBvCotg+YS5H4EP/xqcWQz3GBHE9c8RIVArWXEwXkZa2wQvIEqWQxrBIDOYOVi4dqdvKJRc0ofIAcYPHY1CIPwsb5T9/RQU1nlUe1y49z/AXPlNVs4v55O5XDcy6Pg8bmjb8/NyUwI2ljVvCA/mdiCufF+BkV7DS0BWpndSnTusIusS0XmtSUOw6hpyyfHcgHLKlDns4VaZvl8370bJAkDjzocitdYUuuaL0Ojpgkivrhjag37NoJA8O0JRrCuBJgWn0pIj+6Qdq+UtDunnlx/hr9AtyhvIPwCxlDIuTeSLcRbo444scrGxjwS+2hE7KPVlUhZfOaH5PvNfLDU4+vnoAVVCkiNLFAGDv4DSJnUG+p5lEPPc1y9gGyWnxeLCD1Ykx778s8W5+vQp8jZMy963eOwCJAJrvuixdPe9wTapa8iB5o8I6F4NvIRfhQ8cU9Jixm1twRQ02FR15M4qGCH4QQ3dMTFw4u423FePomHPiN6dby8AISKBWUtVn9fhBnIMxQ0UDaBSlz98/xTdU4GJvd+5Sjmb7HSEOwqcZQucpdsV1IxMK2bsipuusc0xLW7kJ/X3O02QIcychV4iLHZTG4xy183dbIPWk4QxehTEWy/gZtXIsJdtmejwbsNa1PUhCUOPIXn2b2HLQdnUK298IEeFgQTCkn09gAOeygH3OYYMfl86illv5zeI9vdHPp8j+rFKHYncQsDNSRdbHOmqsXgB8zTHC+/OCyw6ubGOvqXszoGlwFVl7gpRvzYBIn7ic33dZM2Y7hScfYkLBHi3pK1VtJS6s7GBJSWUBPfPQ0/JEFcJ4C2piuR6ZwYwwnvEbdjEme954uPTaFMLl8Ntr6v2buRMjzjtIEUx/nb3Cp/WE9PIxV8vBswD2Y/Vm8yrxanxtdg66SQ/2IjwcwD3mSoCCoyr3PGPkKpsNEGhr0lc8aOT6uRRtzd2MVbPefMHVcPWxrElKOHhJucxzj5C0EiixoO8bCPL6yH/Ymh9dL8PX7J9oHt/4hl8Q0ta+zG4UJx6JaQVuZLrl8B3mqd6KMikV57lifWPanOozQk5GHPnA0mz/n8P/Gr7sxX4yW34t4rE34pscdRHf5jnvUk91Ghgf+uWK/FQD8WL/PXzM+TZPoRmumAdD+zx+yedfeIoaFnsdT3Cw5HyShepDT61amf+RB3m0t/zIr1QGJZMdcdH8aDMMpExW7OsJihT8OA+BVY0Wr6Ef4bpgt0464OypIsGHBtrweZkLpUevyZEMFujJTr1G2bAr9nmU0XahE55MlEjVgLAgcP6JtutMA+RnbmFo0ZeuUqB2SxQbtiXlMFx6Uyl0PksgwqQ+sQIk";
    //    byte[] encrypted = aead.encrypt(input.getBytes(), SecurityUtils.getHashedToken(token));
    Key secretKey;
    secretKey = (Key) new SecretKeySpec(SecurityUtils.getHashedToken(token), "AES");
    String decrypted = decrypt(input);
    System.out.println(new String(decrypted));
  }

  public static String decrypt(String encrypted) throws Exception {
    String token = "abc";
    SecretKey key = new SecretKeySpec(SecurityUtils.getHashedToken(token), "AES"); // key is 16 zero bytes

    byte[] decoded = Base64.getDecoder().decode(encrypted);

    byte[] iv = Arrays.copyOfRange(decoded, 0, 12);

    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
    GCMParameterSpec ivSpec = new GCMParameterSpec(16 * Byte.SIZE, iv);
    cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

    byte[] ciphertext = cipher.doFinal(decoded, 12, decoded.length - 12);

    String result = new String(ciphertext, "UTF8");

    return result;
  }

  //
  //  public static String decrypt(String strToDecrypt, String secret)
  //      throws NoSuchPaddingException, NoSuchAlgorithmException,
  // InvalidAlgorithmParameterException,
  //          InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
  //    final Integer CIPHER_ALGORITHM_KEY_SIZE = 16;
  //    final String CIPHER_ALGORITHM_NAME = "AES";
  //    //    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv, 0,
  // CIPHER_ALGORITHM_KEY_SIZE);
  //    SecretKeySpec secretKeySpec =
  //        new SecretKeySpec(key, 0, CIPHER_ALGORITHM_KEY_SIZE, CIPHER_ALGORITHM_NAME);
  //
  //      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
  //      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
  //    byte[] result = cipher.doFinal(strToDecrypt.getBytes(), 0, strToDecrypt.getBytes().length);
  //    return new String(result);
  //  }
}

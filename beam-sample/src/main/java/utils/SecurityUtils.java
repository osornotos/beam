package utils;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadKeyTemplates;

import javax.xml.bind.DatatypeConverter;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtils {

  public static byte[] decrypt(byte[] encryptedBytes, String token)
      throws GeneralSecurityException {
    Aead aead = getAead();
    byte[] decrypted = aead.decrypt(encryptedBytes, getHashedToken(token));
    return decrypted;
  }

  public static byte[] encrypt(byte[] input, String token) throws GeneralSecurityException {
    Aead aead = getAead();
    byte[] encrypted = aead.encrypt(input, getHashedToken(token));
    return encrypted;
  }

  private static Aead getAead() throws GeneralSecurityException {
    AeadConfig.register();
    KeysetHandle keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES256_GCM);
    Aead aead = keysetHandle.getPrimitive(Aead.class);
    return aead;
  }

  public static byte[] getHashedToken(String token) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(token.getBytes());
    byte[] digest = md.digest();
    return DatatypeConverter.printHexBinary(digest).toLowerCase().getBytes();
  }
}

package ama.authenticator.userlogin.manager;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

/**
 * credential util class.
 */
public final class CredentialsManager {

  private CredentialsManager() {
    // do not allow instantiation
  }

  /**
   * replace char array with * characters.
   * @param password
   */
  public static void concealPassWordMemory(char[] password) {
    if(password == null || password.length == 0) {
      return;
    }
    for (int i =0; i < password.length; i++) {
      password[i] = '*';
    }
  }

  /**
   * hash a char array string using PBKDF2WithHmacSHA1 algorithm.
   *
   * @param unencryptedPassword
   * @return
   */
  public static char[] hashPassword(char[] unencryptedPassword) {
    //this could potentially be random generated and persisted for each user.
    byte[] salt = new byte[] {34, -45, 12, 56, -38, 48, -27};
    try {
      int derivedKeyStrength = 160;
      int repetition = 1000;
      KeySpec spec = new PBEKeySpec(unencryptedPassword, salt, repetition, derivedKeyStrength);
      SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      byte[] encodedSecret = secretKeyFactory.generateSecret(spec).getEncoded();
      char[] result = new char[encodedSecret.length*2];
      int index = 0;
      for (int i = 0; i < encodedSecret.length; i++) {
        addByteHexToCharArray(result, encodedSecret[i], index);
        index += 2;
      }
      return result;
    } catch (Exception e) {
      // Ideally we should log this to a proper logger for letter investigation.
      throw new RuntimeException("Error when hashing pass with PBKDF2WithHmacSHA1" + e.getMessage());
    }
  }

  /**
   * Convert each byte array to hexadecimal representation in char array.
   *
   * @param charArray
   * @param theByte
   * @param index
   */
  private static void addByteHexToCharArray(char[] charArray, byte theByte, int index) {
    char[] byteHex = Integer.toHexString(0xFF & theByte).toCharArray();
    if(byteHex == null || byteHex.length == 0){
      return;
    }
    for(char c : byteHex) {
      charArray[index] = c;
      ++index;
    }
  }
}

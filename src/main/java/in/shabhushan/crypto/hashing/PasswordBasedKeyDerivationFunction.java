package in.shabhushan.crypto.hashing;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordBasedKeyDerivationFunction {
  private static final String PBKDF2_FUNCTION = "PBKDF2WithHmacSHA1";

  /**
   * Get Password Based Key Derivation Function
   */
  public static byte[] getPBKDF2Hash(String password, int hashLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
    // Create Salt
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);

    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, hashLength);

    return SecretKeyFactory.getInstance(PBKDF2_FUNCTION).generateSecret(spec).getEncoded();
  }

  public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
    System.out.println(Base64.getEncoder().encodeToString(getPBKDF2Hash("pass", 256)));
  }
}

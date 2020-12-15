package in.shabhushan.crypto.obfuscation;

import org.junit.Test;

import static org.eclipse.jetty.util.security.Password.deobfuscate;
import static org.eclipse.jetty.util.security.Password.obfuscate;
import static org.junit.Assert.assertEquals;

public class PasswordObfuscationTest {
  @Test
  public void testObfuscation() {
    String password = "password";

    String obfuscatedPassword = obfuscate(password);

    System.out.println("Obfuscated Password :: " + obfuscatedPassword);

    assertEquals(password, deobfuscate(obfuscatedPassword));
  }
}

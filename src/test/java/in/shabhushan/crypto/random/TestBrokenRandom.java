package in.shabhushan.crypto.random;


import org.junit.Test;

import static in.shabhushan.crypto.random.BrokenRandom.getGuessedRandomNumbers;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBrokenRandom {
  @Test
  public void testRandom() {
    long guessedRandomNumbers = getGuessedRandomNumbers(10);

    System.out.println(guessedRandomNumbers);

    assertTrue(0 <= guessedRandomNumbers);
  }
}

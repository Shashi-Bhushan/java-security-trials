package in.shabhushan.crypto.random;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Proves that random is not cryptographically secure.
 * based on https://jazzy.id.au/2010/09/20/cracking_random_number_generators_part_1.html
 *
 * It's not that Random is broken - it should just be used in different scenarios.
 * Of course, you could always use SecureRandom. But in general, SecureRandom is noticeably slower than pure Random.
 * And there are cases where you are only interested in good statistical properties and excellent performance,
 * but you don't really care about security:
 * Monte-Carlo simulations are a good example.
 *
 * https://franklinta.com/2014/08/31/predicting-the-next-math-random-in-java/
 */
public class BrokenRandom {
  private static long multiplier = 0x5DEECE66DL;
  private static long addend = 0xBL;
  private static long mask = (1L << 48) - 1;

  /**
   * Returns how many times function was able to guess the next generated Random number
   */
  public static long getGuessedRandomNumbers(int iterations) {
    return IntStream.range(0, iterations).mapToObj(index -> {
      Random random = new Random();

      long v1 = random.nextInt();
      long v2 = random.nextInt();

      for (int i = 0; i < 65536; i++) {
        long seed = v1 * 65536 + i;

        if ((((seed * multiplier + addend) & mask) >>> 16) == v2) {
          System.out.println("Seed found: " + seed);
          return true;
        }
      }

      System.out.println("NOT FOUND");
      return false;
    }).filter(a -> a).count();
  }
}

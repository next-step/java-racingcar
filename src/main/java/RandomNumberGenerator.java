import java.util.Random;

public class RandomNumberGenerator {

  private RandomNumberGenerator() {}

  private static final Random RANDOM = new Random();
  static {
    RANDOM.setSeed(System.currentTimeMillis());
  }

  public static int generate(int maxNumber) {
    return RANDOM.nextInt(maxNumber);
  }
}

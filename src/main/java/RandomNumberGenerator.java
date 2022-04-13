import java.util.Random;

public class RandomNumberGenerator {

  private static final Random RANDOM = new Random();
  private static final int MAX_RANDOM_VALUE = 10;

  public RandomNumberGenerator() {
    RANDOM.setSeed(System.currentTimeMillis());
  }

  public int generate() {
    return RANDOM.nextInt(MAX_RANDOM_VALUE);
  }
}

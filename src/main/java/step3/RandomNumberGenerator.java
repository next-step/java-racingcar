package step3;

import java.util.Random;

public class RandomNumberGenerator {

  public static final int BOUNDARY = 9;

  private final Random random = new Random();

  public int generate() {
    return random.nextInt(BOUNDARY);
  }

}

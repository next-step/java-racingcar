package study.racing;

import java.util.Random;

public class RandomNumberAssigner {

  private static final Random random = new Random();
  private static final int BOUND = 10;

  public static int getRandomNumber() {
    return random.nextInt(BOUND);
  }

}

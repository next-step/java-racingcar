package study.racing;

import java.util.Random;

public class RandomNumberAssigner {

  private static final Random random = new Random();

  public static int getRandomNumber() {
    return random.nextInt(10);
  }

}

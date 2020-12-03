package step3.domain;

import java.util.Random;

public class RacingRule {

  private static final Random random = new Random();
  public static final int STANDARD_FOR_MOVING = 4;

  public static boolean possibleToMove() {
    return getRandomNumber() > STANDARD_FOR_MOVING;
  }

  static int getRandomNumber() {
    return  random.nextInt(10);
  }

}

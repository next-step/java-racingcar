package carRacing.level3;

import java.util.Random;

public class RaceSetting {

  private static final Integer BOUNDARY = 10;
  private static final Integer PIVOT = 4;

  public static int randomNum() {
    Random random = new Random();
    return random.nextInt(BOUNDARY);
  }

  public static Boolean isMoving(int randomNum) {
    if (randomNum >= PIVOT) {
      return true;
    }
    return false;
  }

}

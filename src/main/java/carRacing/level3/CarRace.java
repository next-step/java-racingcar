package carRacing.level3;

import java.util.Random;

public class CarRace {

  private static final Integer BOUNDARY = 10;
  private static final Integer PIVOT = 4;

  public static int getRandomNum() {
    Random random = new Random();
    return random.nextInt(BOUNDARY);
  }

  public static Boolean canMove(int randomNum) {
    if (randomNum >= PIVOT) {
      return true;
    }
    return false;
  }

}

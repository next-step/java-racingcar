package carRacing.level3;

import java.util.Random;

public class CarRace {
  public static int getRandomNum() {
    Random random = new Random();
    return random.nextInt(10);
  }
}

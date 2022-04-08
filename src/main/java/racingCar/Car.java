package racingCar;

import java.util.Random;

public class Car {

  private int randomValue;
  private final static int MIN_VALUE = 3;
  private final static String STEP = "-";
  private final static int RANDOM_BOUND_VALUE = 10;

  public String move() {
    initRandomValue();
    if (randomValue <= MIN_VALUE) {
      return null;
    }
    return STEP;
  }

  public void initRandomValue() {
    Random random = new Random();
    this.randomValue = random.nextInt(RANDOM_BOUND_VALUE);
  }

  public int getRandomValue() {
    return randomValue;
  }
}

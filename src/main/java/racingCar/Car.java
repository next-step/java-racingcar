package racingCar;

import java.util.Random;

public class Car {

  private final static int MIN_VALUE = 3;
  private final static String STEP = "-";
  private final static int RANDOM_BOUND_VALUE = 10;
  private int randomValue;
  private String meterParser;

  public String step() {
    initRandomValue();
    if (randomValue <= MIN_VALUE) {
      return null;
    }
    return STEP;
  }

  public String move() {
    if(step() == null) return meterParser;
    return meterParser += step();
  }

  public void initRandomValue() {
    Random random = new Random();
    this.randomValue = random.nextInt(RANDOM_BOUND_VALUE);
  }

  public int getRandomValue() {
    return randomValue;
  }
}

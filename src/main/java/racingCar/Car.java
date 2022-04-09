package racingCar;

import java.util.Random;

public class Car {

  private final static int STOP_BOUNDARY_VALUE = 3;
  private final static String STEP = "-";
  private final static int RANDOM_BOUND_VALUE = 10;
  private final static int STOP_RESULT = 0;
  private final static int MOVE_RESULT = 1;
  private int randomValue;
  private int meterParser;

  public int step() {
    initRandomValue();
    if (randomValue <= STOP_BOUNDARY_VALUE) {
      return STOP_RESULT;
    }
    return MOVE_RESULT;
  }

  public void carMeter() {
    this.meterParser += step();
  }

  public String move() {
    return STEP.repeat(Math.max(0, getMeterParser()));
  }

  public int getMeterParser() {
    return meterParser;
  }

  public void initRandomValue() {
    Random random = new Random();
    this.randomValue = random.nextInt(RANDOM_BOUND_VALUE);
  }

  public int getRandomValue() {
    return randomValue;
  }
}

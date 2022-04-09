package racingCar;

import java.util.Random;

public class Car {

  private final static int STOP_BOUNDARY_VALUE = 3;
  private final static String STEP = "-";
  private final static int RANDOM_BOUND_VALUE = 10;
  private final static int STOP_RESULT = 0;
  private final static int MOVE_RESULT = 1;
  private int meterParser;

  public int step() {
    if (getRandomValue() <= STOP_BOUNDARY_VALUE) {
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

  protected int getRandomValue() {
    Random random = new Random();
    return random.nextInt(RANDOM_BOUND_VALUE);
  }

}

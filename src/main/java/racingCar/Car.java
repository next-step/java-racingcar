package racingCar;

public class Car {

  private final static int STOP_BOUNDARY_VALUE = 3;
  private final static String STEP = "-";
  private final static int STOP_RESULT = 0;
  private final static int MOVE_RESULT = 1;
  private int meterParser;

  public int step(int randomNo) {
    if (randomNo <= STOP_BOUNDARY_VALUE) {
      return STOP_RESULT;
    }
    return MOVE_RESULT;
  }

  public void carMeter(int randomNo) {
    this.meterParser += step(randomNo);
  }

  public String move() {
    return STEP.repeat(Math.max(0, getMeterParser()));
  }

  public int getMeterParser() {
    return meterParser;
  }


}

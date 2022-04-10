package racingCar.model;

public class Car {

  private final static int STOP_BOUNDARY_VALUE = 3;
  private final static String STEP = "-";
  private int meterParser;

  public int step(int randomNo) {
    if (randomNo <= STOP_BOUNDARY_VALUE) {
      return meterParser;
    }
    return meterParser += 1;
  }


  public String move() {
    return STEP.repeat(Math.max(0, getMeterParser()));
  }

  public int getMeterParser() {
    return meterParser;
  }


}

package racingcar.step3.ui;

public class InputValue {
  private final int numberOfCars;
  private final int tryCount;

  public InputValue(int numberOfCars, int tryCount) {
    this.numberOfCars = numberOfCars;
    this.tryCount = tryCount;
  }

  public int getNumberOfCars() {
    return numberOfCars;
  }

  public int getTryCount() {
    return tryCount;
  }
}

package step3;

public class Input {
  private int numberOfCars;
  private int numberOfAttempts;

  public int getNumberOfCars() {
    return numberOfCars;
  }

  public int getNumberOfAttempts() {
    return numberOfAttempts;
  }

  public void enter(int numberOfCars, int numberOfAttempts) {
    this.numberOfCars = numberOfCars;
    this.numberOfAttempts = numberOfAttempts;
  }

  public boolean isValid() {
    return numberOfCars != 0 && numberOfAttempts != 0;
  }

}

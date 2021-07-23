package step3;

public class Input {

  private int numberOfCars;
  private int numberOfAttempts;

  public Input(int numberOfCars, int numberOfAttempts) {
    validate(numberOfCars, numberOfAttempts);
    this.numberOfCars = numberOfCars;
    this.numberOfAttempts = numberOfAttempts;
  }

  private void validate(int numberOfCars, int numberOfAttempts) {
    if (isNotPositive(numberOfCars, numberOfAttempts)) {
      throw new IllegalArgumentException("입력 값은 양의 정수여야 한다");
    }
  }

  private boolean isNotPositive(int numberOfCars, int numberOfAttempts) {
    return numberOfCars <= 0 || numberOfAttempts <= 0;
  }

  public int getNumberOfCars() {
    return numberOfCars;
  }

  public int getNumberOfAttempts() {
    return numberOfAttempts;
  }

}

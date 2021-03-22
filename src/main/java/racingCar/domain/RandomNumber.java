package racingCar.domain;

public class RandomNumber {
  private static final int NUMBER_MOVING_CONDITION = 4;

  private final int randomNumber;

  public RandomNumber(int number) {
    if (number < 0 || number > 9) {
      throw new IllegalArgumentException();
    }
    this.randomNumber = number;
  }

  public boolean isMovable() {
    return this.randomNumber >= NUMBER_MOVING_CONDITION;
  }
}

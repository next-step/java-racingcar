package domain;

import model.CarPosition;

public class Car {

  private static final int MIN_NUMBER_TO_MOVE = 4;
  private static final int MOVE_DISTANCE = 1;
  private static final int INITIAL_POSITION = 0;

  private final CarPosition carPosition;

  public Car() {
    this.carPosition = new CarPosition(INITIAL_POSITION);
  }

  public void move(int number) {
    if (number >= MIN_NUMBER_TO_MOVE) {
      carPosition.add(MOVE_DISTANCE);
    }
  }

  public int getPosition() {
    return carPosition.getValue();
  }
}

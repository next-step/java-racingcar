package domain;

import model.CarName;
import model.CarPosition;

public class Car {

  private static final int MIN_NUMBER_TO_MOVE = 4;
  private static final int MOVE_DISTANCE = 1;
  private static final int INITIAL_POSITION = 0;

  private final CarPosition carPosition;
  private final CarName carName;

  public Car(String name) {
    this.carPosition = new CarPosition(INITIAL_POSITION);
    this.carName = new CarName(name);
  }

  public void move(int number) {
    if (number >= MIN_NUMBER_TO_MOVE) {
      carPosition.add(MOVE_DISTANCE);
    }
  }

  public CarInfo getCarInfo() {
    return new CarInfo(carName, carPosition);
  }
}

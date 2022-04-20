package domain;

import java.util.Objects;
import model.CarName;
import model.CarPosition;

public class Car implements Comparable<Car> {

  private static final String COLUMN_MARKER = " : ";
  private static final int MIN_NUMBER_TO_MOVE = 4;
  private static final int MOVE_DISTANCE = 1;
  private static final int INITIAL_POSITION = 0;

  private final CarPosition carPosition;
  private final CarName carName;


  public Car(String name) {
    this(name, INITIAL_POSITION);
  }

  public Car(String name, int position) {
    this.carPosition = new CarPosition(position);
    this.carName = new CarName(name);
  }

  public void move(int number) {
    if (number >= MIN_NUMBER_TO_MOVE) {
      carPosition.add(MOVE_DISTANCE);
    }
  }

  public String markPosition() {
    return carName
        + COLUMN_MARKER
        + carPosition;
  }

  @Override
  public String toString() {
    return carName.toString();
  }

  @Override
  public int compareTo(Car other) {
    return carPosition.compareTo(other.carPosition);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return carName.equals(car.carName) && carPosition.equals(car.carPosition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carPosition, carName);
  }
}

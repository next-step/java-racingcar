package domain;

import static util.Validator.validateArgument;

import java.util.Objects;
import model.CarName;
import model.CarPosition;

public class Car implements Comparable<Car> {

  private static final String COLUMN_MARKER = " : ";
  private static final int MIN_NUMBER_TO_MOVE = 4;
  private static final int MOVE_DISTANCE = 1;
  private static final int INITIAL_POSITION = 0;
  private static final int MIN_MOVE_NUMBER = 0;
  private static final int MAX_MOVE_NUMBER = 9;
  private static final String ERROR_MESSAGE_FOR_INVALID_MOVE_NUMBER = String.format(
      "move()의 인자는 %s이상 %s 이하여야합니다.", MIN_MOVE_NUMBER, MAX_MOVE_NUMBER
  );

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
    validateMoveNumber(number);
    if (number >= MIN_NUMBER_TO_MOVE) {
      carPosition.add(MOVE_DISTANCE);
    }
  }

  public String markPosition() {
    return carName
        + COLUMN_MARKER
        + carPosition;
  }

  public void validateMoveNumber(int number) {
    validateArgument(
        number,
        (arg) -> MIN_MOVE_NUMBER <= number && number <= MAX_MOVE_NUMBER,
        ERROR_MESSAGE_FOR_INVALID_MOVE_NUMBER
    );
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

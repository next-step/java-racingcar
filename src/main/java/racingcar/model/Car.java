package racingcar.model;

import java.util.Objects;

public class Car {

  private static int NAME_MIN_LENGTH = 1;
  private static int NAME_MAX_LENGTH = 5;

  private Position position;

  private String name;

  public Car(int position, String name) {
    validatePosition(position);
    validateName(name);
    this.position = new Position(position);
  }

  public Position getPosition() {
    return position;
  }

  public void moveOrStop(MovingStrategy movingStrategy) {
    if (movingStrategy.movable()) {
      position = position.increment();
    }
  }

  private static void validatePosition(int position) {
    if (position < 0) {
      throw new RuntimeException("음수는 입력할 수 없습니다.");
    }
  }

  private static void validateName(String name) {
    if (name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
      throw new RuntimeException(
          String.format("이름은 %d자 이상, %d자 이하여야 합니다.", NAME_MIN_LENGTH, NAME_MAX_LENGTH)
      );
    }
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
    return Objects.equals(position, car.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }
}

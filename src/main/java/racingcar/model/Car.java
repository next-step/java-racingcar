package racingcar.model;

import java.util.Objects;

public class Car {

  private static final String OUTPUT_FORMAT = "%s : %s";

  private final Name name;

  private Position position;


  public Car(String name, int position) {
    this.name = new Name(name);
    this.position = new Position(position);
  }

  public String getName() {
    return name.getValue();
  }

  public void moveOrStop(MovingStrategy movingStrategy) {
    if (movingStrategy.movable()) {
      position = position.increment();
    }
  }

  public int compareTo(Car other) {
    return position.compareTo(other.position);
  }

  public boolean hasSamePosition(Car other) {
    return compareTo(other) == 0;
  }

  public String createOutput() {
    return String.format(
        OUTPUT_FORMAT,
        name.getValue(),
        "-".repeat(position.getPosition())
    );
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
    return Objects.equals(position, car.position) && Objects.equals(name,
        car.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, name);
  }
}

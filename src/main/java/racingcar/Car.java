package racingcar;

import java.util.Objects;

public class Car {

  private final Name name;
  private final Position position;

  public Car(String name) {
    this(new Name(name), new Position());
  }

  public Car(String name, int position) {
    this(new Name(name), new Position(position));
  }

  public Car(Name name, Position position) {
    this.name = name;
    this.position = position;
  }

  public void addScore(int additionalScore) {
    this.position.add(additionalScore);
  }

  public int getPosition() {
    return this.position.getValue();
  }

  public void move() {
    this.position.move();
  }

  public String showPosition(String marker) {
    return this.position.showPosition(marker);
  }

  public String getName() {
    return this.name.toString();
  }

  public boolean isWinner(int winnerScore) {
    return this.position.isSameAs(winnerScore);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car other = (Car) o;
    return Objects.equals(name, other.name) &&
        Objects.equals(position, other.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, position);
  }
}

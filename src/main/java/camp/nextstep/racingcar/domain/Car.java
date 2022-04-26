package camp.nextstep.racingcar.domain;

import java.util.Objects;

public class Car {

  private final CarName name;
  private Position position;

  public Car(String name) {
    this(name, new Position());
  }

  public Car(String name, Position position) {
    this.name = new CarName(name);
    this.position = position;
  }

  public void move(MoveCondition condition) {
    if (condition.isSatisfied()) {
      position.moveForward();
    }
  }

  public Position getPosition() {
    return position;
  }

  public String getName() {
    return name.getName();
  }

  public boolean isSamePosition(Car car) {
    return Objects.equals(this.getPosition(), car.getPosition());
  }

  public Position maxPosition(Position maxPosition) {
    return position.maxPosition(maxPosition);
  }
}

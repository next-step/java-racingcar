package camp.nextstep.racingcar.domain;

import java.util.Objects;

public class Car {

  private final CarName name;
  private Position position;

  public Car(String name) {
    this.name = new CarName(name);
    this.position = new Position(0);
  }

  public void move(MoveCondition condition) {
    if (!condition.isSatisfied()) {
      return;
    }
    position.moveForward();
  }

  public int getPosition() {
    return position.getPosition();
  }

  public String getName() {
    return name.getName();
  }

  public boolean isSamePosition(Car car) {
    return Objects.equals(this.getPosition(), car.getPosition());
  }
}

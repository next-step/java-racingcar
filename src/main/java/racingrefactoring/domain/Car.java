package racingrefactoring.domain;

public class Car {

  private final Name name;

  private Position position;

  public Car(String name) {
    this.name = new Name(name);
    this.position = new Position();
  }

  public void move(MoveStrategy moveStrategy) {
    if (moveStrategy.isMovable()) {
      position.move();
    }
  }

  public String getName() {
    return name.getName();
  }

  public int getPosition() {
    return position.getPosition();
  }

  public boolean isMaxPosition(int maxPosition) {
    return position.isSame(maxPosition);
  }
}

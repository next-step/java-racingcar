package racingrefactoring.domain;

public class Car {

  private final Name name;

  private final Position position;

  public Car(String name) {
    this.name = new Name(name);
    this.position = new Position();
  }

  protected Car(String name, int position) {
    this.name = new Name(name);
    this.position = new Position(position);
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

  public boolean isMaxPosition(MaxPosition maxPosition) {
    return position.isMax(maxPosition);
  }
}

package racingCar.domain;

public class Car {

  private final Name name;
  private Position position;

  public Car(String name, Integer position) {
    this.name = new Name(name);
    this.position = new Position(position);
  }

  public String getName() {
    return this.name.getName();
  }

  public Integer getPosition() {
    return this.position.getPosition();
  }

  public TryResult move(MovableStrategy movable) {
    if (movable.movable()) {
      this.position = this.position.move();
    }
    return new TryResult(name.getName(), position.getPosition());
  }

}

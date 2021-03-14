package racingcar.model;

public class Car {

  private Name name;
  private Position position;

  public Car(String name) {
    this(name.trim(), 0);
  }

  public Car(String name, int position) {
    this.name = new Name(name.trim());
    this.position = new Position(position);
  }

  public Position getPosition() {
    return position;
  }

  public Name getName() {
    return name;
  }
}

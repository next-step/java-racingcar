package step4;

public class Car {

  private final String name;
  private int location;
  private final MoveStrategy moveStrategy;

  public Car(String name, MoveStrategy moveStrategy) {
    checkNameLength(name);
    this.name = name;
    this.location = 0;
    this.moveStrategy = moveStrategy;
  }

  public void move() {
    this.location += moveStrategy.getMoveDistance();
  }

  public String getName() {
    return name;
  }

  public int getLocation() {
    return location;
  }

  private void checkNameLength(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
    }
  }
}

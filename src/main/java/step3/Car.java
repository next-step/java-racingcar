package step3;

public class Car {

  private int location;
  private final MoveStrategy moveStrategy;

  public Car(MoveStrategy moveStrategy) {
    this.location = 0;
    this.moveStrategy = moveStrategy;
  }

  public void move() {
    this.location += moveStrategy.getMoveDistance();
  }

  public int getLocation() {
    return location;
  }
}

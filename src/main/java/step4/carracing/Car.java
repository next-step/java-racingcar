package step4.carracing;

public class Car {
  private static final int INIT_POSITION = 0;
  private static final int MOVE_STEP = 1;

  private final Position position;
  private final CarName name;
  private final CarMoveStrategy carMoveStrategy;

  public Car(int position, String name, CarMoveStrategy carMoveStrategy) {
    this.position = new Position(position);
    this.name = new CarName(name);
    this.carMoveStrategy = carMoveStrategy;
  }

  public Car(String name, CarMoveStrategy carMoveStrategy) {
    this(INIT_POSITION, name, carMoveStrategy);
  }

  public void move() {
    if (carMoveStrategy.shouldMove()) {
      position.increase(MOVE_STEP);
    }
  }

  public String getName() {
    return name.getValue();
  }

  public boolean isSame(int value) {
    return position.isSame(value);
  }

  public int getMax(int compareValue) {
    return position.getMax(compareValue);
  }

  public String getStatus() {
    return name.getValue() + " : " + position.getStatus();
  }
}

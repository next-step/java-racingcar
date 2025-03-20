package step4.carracing;

public class Car {
  private static final int INIT_POSITION = 1;
  private int position;
  private final String name;
  private final CarMoveStrategy carMoveStrategy;

  private Car(String name, CarMoveStrategy carMoveStrategy) {
    this.position = INIT_POSITION;
    this.name = name;
    this.carMoveStrategy = carMoveStrategy;
  }

  public static Car of(String name, CarMoveStrategy carMoveStrategy) {
    return new Car(name, carMoveStrategy);
  }

  public void move() {
    if (carMoveStrategy.shouldMove()) {
      position++;
    }
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }
}

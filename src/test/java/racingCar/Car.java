package racingCar;

public class Car {

  private int distance;
  private final String name;

  public Car(String name) {
    this.name = name;
  }

  public void move(MovableStrategy movable) {
    this.distance += movable.movable() ? 1 : 0;
  }

  public int getDistance() {
    return this.distance;
  }


}

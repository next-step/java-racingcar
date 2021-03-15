package racingCar;

public class Car {

  private int distance;

  public void move(MovableStrategy movable) {
    this.distance += movable.movable() ? 1 : 0;
  }

  public int getDistance() {
    return this.distance;
  }


}

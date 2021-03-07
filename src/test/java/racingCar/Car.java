package racingCar;

public class Car {
  private int distance;

  public void move(int movedDistance) {
    this.distance += movedDistance >= 4 ? 1 : 0;
  }

  public int getDistance() {
    return this.distance;
  }

}

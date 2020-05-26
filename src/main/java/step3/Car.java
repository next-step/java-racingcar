package step3;

public class Car {
  private int distance;
  private final CarMovingStartegy carMovingStartegy;

  public Car(CarMovingStartegy carMovingStartegy) {
    this.carMovingStartegy = carMovingStartegy;
  }

  public int getDistance() {
    return distance;
  };

  public void move() {
    if (carMovingStartegy.isCanMove()) {
      distance++;
    }
  }
}

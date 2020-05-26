package step3;

public class Car {
  private final String name;
  private int distance;
  private final CarMovingStartegy carMovingStartegy;

  public Car(CarMovingStartegy carMovingStartegy) {
    this.name = "";
    this.carMovingStartegy = carMovingStartegy;
  }

  public Car(String name, CarMovingStartegy carMovingStartegy) {
    this.name = name;
    this.carMovingStartegy = carMovingStartegy;
  }

  public String getName() {
    return name;
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

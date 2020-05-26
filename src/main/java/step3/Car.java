package step3;

public class Car implements Comparable<Car> {
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

  @Override
  public int compareTo(Car target) {
    if (this.distance == target.distance) {
      return 0;
    }
    return this.distance < target.distance ? -1 : 1;
  }
}

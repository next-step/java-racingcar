package racing_game.model;

public class Car implements Comparable<Car> {

  private final String name;
  private int distance;
  private final CarMovingStartegy carMovingStartegy;

  public Car(String name, CarMovingStartegy carMovingStartegy) {
    this.name = name;
    this.carMovingStartegy = carMovingStartegy;
  }

  public String getName() {
    return name;
  }

  public int getDistance() {
    return distance;
  }

  public void move() {
    if (carMovingStartegy.isCanMove()) {
      distance++;
    }
  }

  @Override
  public int compareTo(Car target) {
    return Integer.compare(this.distance, target.distance);
  }
}

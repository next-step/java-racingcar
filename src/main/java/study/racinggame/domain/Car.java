package study.racinggame.domain;

import study.racinggame.util.NameValidator;

public class Car implements Comparable<Car> {

  public static final int DEFAULT_DISTANCE = 0;
  private final String name;
  private int distance;

  public Car(String name) {
    this(name,DEFAULT_DISTANCE);
  }

  public Car(String name, int distance) {
    this.name = NameValidator.validatedCarName(name);
    this.distance = distance;
  }

  public String name() {
    return name;
  }

  public int distance() {
    return distance;
  }

  public void forward(GameStrategy racingStrategy) {
    if (racingStrategy.movable()) {
      distance++;
    }
  }

  public boolean isSameDistance(int distance) {
    return this.distance == distance;
  }

  @Override
  public int compareTo(Car otherCar) {
    return Integer.compare(otherCar.distance(), distance);
  }
}

package step4.model;

import step4.strategy.Strategy;

public class Car {

  private int location;
  private final String name;

  public Car(String name) {
    this(name, 0);
  }

  public Car(String name, int location) {
    this.name = name;
    this.location = location;
  }

  public Car move(Strategy strategy) {
    if (strategy.isMovable()) location += 1;
    return this;
  }

  public String showCarName() {
    return name;
  }

  public int showCarLocation() {
    return location;
  }
}
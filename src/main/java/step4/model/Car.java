package step4.model;

import step4.strategy.CarMovingStrategy;
import step4.strategy.Strategy;

public class Car {
  private int location;
  private final Strategy carMovingStrategy;

  public Car() {
    this(0, new CarMovingStrategy());
  }

  public Car(int location, Strategy strategy){
    this.location = location;
    this.carMovingStrategy = strategy;
  }

  public int move() {
    if (carMovingStrategy.isMovable()) location += 1;
    return location;
  }

  public int showCarLocation() {
    return location;
  }
}
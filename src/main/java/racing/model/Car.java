package racing.model;

import racing.strategy.CarMovingStrategy;
import racing.strategy.Strategy;

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

  // TODO: Move할 때 strategy 주입해야 함
  public int move() {
    if (carMovingStrategy.isMovable()) location += 1;
    return location;
  }

  public int showCarLocation() {
    return location;
  }
}
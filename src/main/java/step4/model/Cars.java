package step4.model;

import step4.strategy.CarMovingStrategy;
import step4.strategy.Strategy;

import java.util.List;

public class Cars {
  private final List<Car> cars;

  private final Strategy strategy;

  public Cars(List<Car> cars) {
    this.cars = cars;
    this.strategy = new CarMovingStrategy();
  }

  public List<Car> getCars() {
    return cars;
  }

  public boolean runCycle() {
    cars.forEach(car -> {
      car.move(strategy);
    });
    return true;
  }
}

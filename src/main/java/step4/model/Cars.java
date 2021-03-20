package step4.model;

import step4.strategy.CarMovingStrategy;
import step4.strategy.Strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    cars.forEach(car -> car.move(strategy));
    return true;
  }

  public List<String> calcChampions() {

    int maxValue = getMaxLocation();
    if (maxValue == 0) {
      return new ArrayList<>();
    }

    return cars.stream()
      .filter(car -> car.showCarLocation() == maxValue)
      .map(Car::showCarName)
      .collect(Collectors.toList());
  }

  private int getMaxLocation() {
    return cars.stream()
      .map(Car::showCarLocation)
      .reduce(0, Math::max);
  }
}
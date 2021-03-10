package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class Winner {

  private int getMaxLocation(List<Car> cars) {
    return cars.stream().mapToInt(Car::getLocation).max().orElse(0);
  }

  public boolean isWinner(Car car, int maxLocation) {
    return car.getLocation() == maxLocation;
  }

  public List<Car> getWinner(List<Car> cars) {
    int maxLocation = getMaxLocation(cars);
    return cars.stream().filter(car -> isWinner(car, maxLocation)).collect(Collectors.toList());
  }
}

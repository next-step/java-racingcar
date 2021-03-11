package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Winner {

  public List<Car> nameOfWinner = new ArrayList<>();

  private int getMaxLocation(List<Car> cars) {
    return cars.stream().mapToInt(Car::getLocation).max().orElse(0);
  }

  public boolean isWinner(Car car, int maxLocation) {
    return car.getLocation() == maxLocation;
  }

  private void addWinner(Car car, int maxLocation) {
    if (isWinner(car, maxLocation)) {
      nameOfWinner.add(car);
    }
  }

  public void decideWinner(List<Car> cars) {
    int maxLocation = getMaxLocation(cars);
    cars.forEach(car -> addWinner(car, maxLocation));
  }
}

package racing.simulator;

import racing.types.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGameWinnerSelector {

  public List<Car> select(List<Car> cars) {
    if (cars.isEmpty()) {
      return new ArrayList<>();
    }

    int maxLocation = cars.stream()
        .max(Comparator.comparingInt(Car::getLocation))
        .get()
        .getLocation();

    return cars.stream()
        .filter(car -> car.getLocation() == maxLocation)
        .collect(Collectors.toList());
  }

}

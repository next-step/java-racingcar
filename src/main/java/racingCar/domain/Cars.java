package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private List<Car> cars;

  public Cars(List<Car> cars) {

    this.cars = cars;
  }

  public List<TryResult> move() {
    List<TryResult> tryResults = new ArrayList<>();
    for (Car car : cars) {
      tryResults.add(car.move(new RandomMovable()));
    }
    return tryResults;
  }

  public List<Car> determineWinners() {
    int max = getMaxPosition(cars);

    return cars.stream()
        .filter(car -> car.getPosition() == max)
        .collect(Collectors.toList());
  }

  private int getMaxPosition(List<Car> cars) {
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(-1);
  }

}

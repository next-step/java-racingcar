package racingrefactoring.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingrefactoring.util.FactoryCar;

public class CarGroup {

  List<Car> cars;

  public CarGroup(String carNames) {
    this.cars = FactoryCar.createCars(carNames);
  }

  protected CarGroup(Car ... cars) {
    this.cars = List.of(cars);
  }

  public CarGroup moveCars(MoveStrategy moveStrategy) {
    cars.forEach(car -> car.move(moveStrategy));
    return this;
  }

  public List<Car> getCars() {
    return cars;
  }

  public List<String> findWinners() {
    int maxPosition = findMaxPosition();

    return cars.stream()
        .filter(car -> car.isMaxPosition(maxPosition))
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  private int findMaxPosition() {
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);
  }
}

package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> cars;

  public Cars(final List<Car> cars) {
    this.cars = cars;
  }

  public static Cars createCars(List<String> carNames) {
    return carNames.stream()
            .map(Car::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(cars);
  }

  public List<String> getWinnersName() {
    Car farthestCar = cars.stream()
            .max(Car::compareTo)
            .orElseThrow(() -> new IllegalStateException("경주에 참가한 자동차가 존재하지 않습니다."));

    return cars.stream()
            .filter(car -> car.isSamePosition(farthestCar))
            .map(Car::getName)
            .collect(Collectors.toList());
  }

  public void moveCars(final MoveStrategy moveStrategy) {
    cars.forEach(car -> car.move(moveStrategy));
  }
}
package step3.domain;

import step3.service.RacingRule;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
  private final List<Car> cars;

  public Cars(List<String> carNames) {
    if (carNames == null) {
      throw new IllegalArgumentException();
    }
    this.cars = carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());
  }

  public void race(RacingRule racingRule) {
    cars.forEach(car -> car.move(racingRule.getTargetNumber()));
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(this.cars);
  }

  public List<String> getWinnerCarNames() {
    return this.getCars().stream()
        .filter(car -> car.getDistance() == maxDistanceOfCars())
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  private int maxDistanceOfCars() {
    return this.getCars().stream()
        .mapToInt(Car::getDistance)
        .max()
        .orElseThrow(NoSuchElementException::new);
  }
}


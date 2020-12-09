package step3.domain;

import step3.service.RacingRule;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
  private final List<Car> cars;

  public Cars(List<String> carNames) {
    this.cars = carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());
  }

  public void race(RacingRule racingRule) {
    cars.forEach(car -> {
      if (racingRule.canMove(racingRule.getTargetNumber())) {
        car.move();
      }
    });
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(this.cars);
  }

  public List<Car> getWinnerCars() {
    return this.getCars().stream()
        .filter(car -> car.getDistance() == maxDistanceOfCars())
        .collect(Collectors.toList());
  }

  private int maxDistanceOfCars() {
    return this.getCars().stream()
        .mapToInt(Car::getDistance)
        .max()
        .orElseThrow(NoSuchElementException::new);
  }
}


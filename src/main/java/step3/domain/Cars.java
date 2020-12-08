package step3.domain;

import step3.service.RacingRule;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
  private static final String SPLIT_FLAG = ",";
  private final List<Car> cars;

  public Cars(String carNames) {
    this.cars = splitCarNames(carNames).stream()
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

  private List<String> splitCarNames(String carNames) {
    return Arrays.asList(carNames.split(SPLIT_FLAG));
  }

  private int maxDistanceOfCars() {
    return this.getCars().stream()
        .mapToInt(Car::getDistance)
        .max()
        .orElseThrow(NoSuchElementException::new);
  }
}


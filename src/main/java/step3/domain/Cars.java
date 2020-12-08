package step3.domain;

import step3.service.RacingRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

  private List<String> splitCarNames(String carNames) {
    return Arrays.asList(carNames.split(SPLIT_FLAG));
  }

}


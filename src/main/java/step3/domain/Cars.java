package step3.domain;

import step3.service.RacingRule;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
  private final List<Car> cars;

  public Cars(int number) {
    this.cars = Stream.generate(Car::new)
        .limit(number)
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
}

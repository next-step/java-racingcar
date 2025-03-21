package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.random.NumberGenerator;

public class Racing {
  private Cars cars;
  private final NumberGenerator numberGenerator;

  public Racing(Cars cars, NumberGenerator numberGenerator) {
    this.cars = cars;
    this.numberGenerator = numberGenerator;
  }

  public Cars start() {
    List<Car> movedCars = cars.stream()
        .map(this::tryMove)
        .collect(Collectors.toList());

    return new Cars(movedCars);
  }

  private Car tryMove(Car car) {
    if (numberGenerator.generateNumber() >= 4) {
      car.move();
    }
    return car;
  }

  public Cars getCars() {
    return cars;
  }

}

package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.random.NumberGenerator;

public class Racing {
  private List<Car> cars;
  private final NumberGenerator numberGenerator;

  public Racing(List<String> carNames, NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
    prepareCars(carNames);
  }

  private void prepareCars(List<String> carNames) {
    this.cars = carNames.stream()
        .map(Car::new)
        .collect(Collectors.toList());
  }

  public List<Car> start() {
    return cars.stream()
        .map(this::tryMove)
        .collect(Collectors.toList());
  }

  private Car tryMove(Car car) {
    if (numberGenerator.generateNumber() >= 4) {
      car.move();
    }
    return car;
  }

  public List<Car> getCars() {
    return cars;
  }

}

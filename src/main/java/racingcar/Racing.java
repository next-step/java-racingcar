package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.random.NumberGenerator;

public class Racing {
  private List<Car> cars;
  private final NumberGenerator numberGenerator;

  public Racing(int carCount, NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
    prepareCars(carCount);

  }

  private void prepareCars(int carCount) {
    this.cars = IntStream.range(0, carCount)
        .mapToObj(Car::new)
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

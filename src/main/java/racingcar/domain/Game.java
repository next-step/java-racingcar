package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomMovingStrategy;

public class Game {

  private final Cars cars;

  protected Game(Cars cars) {
    this.cars = cars;
  }

  public Cars doRace() {
    this.cars.getCarList().forEach(car -> {
      RandomMovingStrategy strategy = RandomMovingStrategy.create();
      car.updatePosition(strategy);
    });
    return this.cars;
  }

  public List<Car> calculateWinner(List<Car> cars) {
    int longest = cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElseThrow(() -> new RuntimeException("무엇인가 이상하네요."));

    return cars.stream()
        .filter(car -> car.getPosition() == longest)
        .collect(Collectors.toList());
  }

  public Cars getCars() {
    return cars;
  }

  public static Game create(Cars cars) {
    return new Game(cars);
  }
}

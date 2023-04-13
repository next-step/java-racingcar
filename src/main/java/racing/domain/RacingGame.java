package racing.domain;

import java.util.List;
import racing.util.RandomNumberGenerator;

public class RacingGame {

  private final List<Car> cars;

  public RacingGame(String carsName) {
    cars = CarFactory.createCars(carsName);
  }

  /**
   * 게임을 한번 실행 한 경우를 의미한다.
   */
  public List<Car> play() {
    for (Car car : cars) {
      car.move(RandomNumberGenerator.generate());
    }
    return cars;
  }

  public String[] findWinners() {
    int maxPosition = findMaxPosition();
    return cars.stream()
        .filter(car -> car.position() == maxPosition)
        .map(Car::name)
        .toArray(String[]::new);

  }

  private int findMaxPosition() {
    return cars.stream()
        .mapToInt(Car::position)
        .max()
        .orElse(0);
  }
}

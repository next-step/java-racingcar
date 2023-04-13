package racing.domain;

import java.util.List;
import racing.util.RandomNumberGenerator;

public class RacingGame {

  private final List<Car> cars;

  public RacingGame(int numberOfCars) {
    cars = CarFactory.createCars(numberOfCars);
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

}

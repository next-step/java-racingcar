package racingcar.domain;

import java.util.List;
import racingcar.util.RandomUtil;

public class Game {

  private final List<Car> cars;

  protected Game(Cars cars) {
    this.cars = cars.getCars();
  }

  public List<Car> doRace() {
    this.cars.forEach(element -> {
      int random = RandomUtil.getRandomValue();
      element.updatePosition(random);
    });
    return this.cars;
  }

  public List<Car> getCars() {
    return cars;
  }

  public static Game create(Cars cars) {
    return new Game(cars);
  }
}

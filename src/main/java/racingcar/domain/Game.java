package racingcar.domain;

import racingcar.util.RandomUtil;

public class Game {

  private final Cars cars;

  protected Game(Cars cars) {
    this.cars = cars;
  }

  public Cars doRace() {
    this.cars.getCarList().forEach(element -> {
      int random = RandomUtil.getRandomValue();
      element.updatePosition(random);
    });
    return this.cars;
  }

  public Cars getCars() {
    return cars;
  }

  public static Game create(Cars cars) {
    return new Game(cars);
  }
}

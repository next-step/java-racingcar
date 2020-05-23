package racingcar.domain;

import racingcar.util.RandomMovingStrategy;

public class Game {

  private final Cars cars;

  protected Game(Cars cars) {
    this.cars = cars;
  }

  public Cars doRace() {
    this.cars.getCarList().forEach(element -> {
      RandomMovingStrategy strategy = RandomMovingStrategy.create();
      element.updatePosition(strategy);
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

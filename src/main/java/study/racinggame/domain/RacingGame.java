package study.racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
  private final Cars cars;

  public RacingGame(int carNumber) {
    this.cars = initialCars(carNumber);
  }

  public GameResult play(int tryNumber) {
    GameResult result = new GameResult();

    for (int i = 0; i < tryNumber; i++) {
      cars.forwardCars();
      result.addRecord(Cars.copyCars(cars));
    }

    return result;
  }

  private static Cars initialCars(int carNumber) {
    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < carNumber; i++) {
      cars.add(new Car());
    }

    return new Cars(cars);
  }
}

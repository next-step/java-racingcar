package study.racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
  private final Cars cars;

  public RacingGame(List<String> carNames) {
    this.cars = initialCars(carNames);
  }

  public GameResult play(int tryNumber) {
    GameResult result = new GameResult();

    for (int i = 0; i < tryNumber; i++) {
      cars.forwardCars();
      result.addRecord(Cars.copyCars(cars));
    }

    return result;
  }

  private static Cars initialCars(List<String> carNames) {
    List<Car> cars = new ArrayList<>();

    for (String carName : carNames) {
      cars.add(new Car(carName));
    }

    return new Cars(cars);
  }
}

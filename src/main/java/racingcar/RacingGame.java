package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingGame {

  public static List<Car> cars;

  public RacingGame() {
    cars = new ArrayList<>();
  }

  public void readyGame(int carCount) {
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car());
    }
  }

  public void run(int attempt) {
    Movement move = new Movement();

    for (int i = 0; i < attempt; i++) {
      move.moveCars(cars);
    }
  }
}

package racingcar;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {

  private InputView inputView;

  public RacingGame() {
    this.inputView = new InputView();;
  }

  public void startRacing() {

    List<Car> cars = inputView.prepare();

    int rounds = inputView.getRounds();

    printRacingStatus(rounds, cars);

  }

  static void printRacingStatus(int rounds, List<Car> cars) {

    for(int round = 1; round <= rounds; round++) {

      ResultView.printCurrentRound(round);

      drive(cars);

      ResultView.addLineBreak();

    }

  }

  static void drive(List<Car> cars) {
    cars.forEach(car -> {
      car.move();
      ResultView.printCurrentPositionOf(car);
    });
  }


}

package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingController {

  private InputView inputView;

  public RacingController(InputView inputView) {
    this.inputView = inputView;
  }

  public void startRacing() {
    inputView.askQuestions();

    String[] names = inputView.getNames();
    int rounds = inputView.getRounds();

    List<Car> cars = CarFactory.generate(names);
    printRacingStatus(rounds, cars);
  }

  static void printRacingStatus(int rounds, List<Car> cars) {
    for(int round = 1; round <= rounds; round++) {
      ResultView.printCurrentRound(round);
      drive(cars);
      ResultView.addLineBreak();
    }

    ResultView.printWinner(cars);
  }

  static void drive(List<Car> cars) {
    cars.forEach(car -> {
      car.move();
      ResultView.printCurrentPositionOf(car);
    });
  }
}

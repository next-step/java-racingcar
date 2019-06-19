package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleResultView;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingController {

  private InputView inputView;
  private ResultView resultView;

  public RacingController(final InputView inputView, final ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  public void startRacing() {
    inputView.askQuestions();

    String[] names = inputView.getNames();
    int rounds = inputView.getRounds();

    List<Car> cars = CarFactory.generate(names);
    printRacingStatus(rounds, cars);
  }

  void printRacingStatus(final int rounds, final List<Car> cars) {
    for(int round = 1; round <= rounds; round++) {
      resultView.printCurrentRound(round);
      drive(cars);
      resultView.addLineBreak();
    }

    resultView.printWinner(cars);
  }

  void drive(final List<Car> cars) {
    cars.forEach(car -> {
      car.move();
      resultView.printCurrentPositionOf(car);
    });
  }
}

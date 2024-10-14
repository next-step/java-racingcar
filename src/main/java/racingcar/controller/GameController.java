package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.strategy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class GameController {
  private final MoveStrategy moveStrategy;

  public GameController(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public void startGame() {
    List<String> carNames = InputView.getCarNames();
    int tryCount = InputView.getTryCount();
    Cars cars = Cars.createCars(carNames);

    ResultView.printExecuteMessage();
    playCarRace(tryCount, cars);
    ResultView.printWinnersName(cars);
  }

  private void playCarRace(int tryCount, Cars cars) {
    for (int i = 0; i < tryCount; i++) {
      cars.moveCars(moveStrategy);
      ResultView.print(cars);
    }
  }
}


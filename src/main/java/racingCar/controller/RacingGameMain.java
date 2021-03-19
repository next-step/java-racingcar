package racingCar.controller;

import java.util.List;
import racingCar.domain.Car;
import racingCar.domain.OverCarNameLengthException;
import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class RacingGameMain {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    String[] carNames = inputView.inputCarNames();
    int tryCount = inputView.inputTryCount();

    RacingGame racingGame = new RacingGame(carNames, tryCount);

    try {
      List<Car> winners = racingGame.start(resultView);
      resultView.printWinners(winners);
    } catch (OverCarNameLengthException e) {
      resultView.printError(e.getMessage());
    }
  }

}

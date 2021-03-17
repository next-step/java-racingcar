package racingCar.controller;

import java.util.List;
import racingCar.domain.Car;
import racingCar.domain.OverCarNameLengthException;
import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class RacingGameMain {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    String[] carNames = inputView.inputCarNames();
    int tryCount = inputView.inputTryCount();

    RacingGame racingGame = new RacingGame(carNames, tryCount);

    try {
      List<Car> winners = racingGame.start(outputView);
      outputView.printWinners(winners);
    } catch (OverCarNameLengthException e) {
      outputView.printError(e.getMessage());
    }
  }

}

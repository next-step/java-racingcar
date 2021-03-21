package racingCar.controller;

import java.util.List;
import racingCar.domain.RacingGame;
import racingCar.domain.OverCarNameLengthException;
import racingCar.domain.TryResult;
import racingCar.view.InputView;
import racingCar.view.ResultView;
import racingCar.view.TryResultsView;

public class RacingGameController {

  public void race() {
    String[] carNames = InputView.inputCarNames();
    int tryCount = InputView.inputTryCount();

    RacingGame racingGame = new RacingGame(carNames, tryCount);

    try {
      ResultView.printResultIntro();
      while(racingGame.isRacing()) {
        TryResultsView tryResultsView = racingGame.race();
        tryResultsView.print();
      }
      ResultView.printWinners(racingGame.getCars());

    } catch (OverCarNameLengthException e) {
      ResultView.printError(e.getMessage());
    }
  }

}

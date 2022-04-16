package racing;

import racing.controller.RacingController;
import racing.domain.strategy.DistanceWinnerStrategy;
import racing.domain.strategy.MoveStrategy;
import racing.domain.strategy.NumberCompareMoveStrategy;
import racing.domain.strategy.RandomNumberGenerator;
import racing.domain.strategy.WinnerCarStrategy;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingGame {

  public static void main(String[] args) {
    RacingInputView racingCarNameInputView = new RacingInputView();
    RacingOutputView racingCarNameOutputView = new RacingOutputView();
    MoveStrategy moveStrategy = new NumberCompareMoveStrategy(new RandomNumberGenerator());
    WinnerCarStrategy winnerCarStrategy = new DistanceWinnerStrategy();

    RacingController racingController = new RacingController(racingCarNameInputView,
        racingCarNameOutputView, moveStrategy, winnerCarStrategy);

    racingController.startGame();
  }

}

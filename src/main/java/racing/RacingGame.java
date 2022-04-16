package racing;

import racing.controller.RacingController;
import racing.domain.strategy.DistanceWinnerStrategy;
import racing.domain.strategy.MoveStrategy;
import racing.domain.strategy.NameLengthValidationStrategy;
import racing.domain.strategy.NameValidationStrategy;
import racing.domain.strategy.NumberCompareMoveStrategy;
import racing.domain.strategy.RandomNumberGenerator;
import racing.domain.strategy.WinnerCarStrategy;
import racing.view.RacingCarNameInputView;
import racing.view.RacingCarNameOutputView;

public class RacingGame {

  public static void main(String[] args) {
    RacingCarNameInputView racingCarNameInputView = new RacingCarNameInputView();
    RacingCarNameOutputView racingCarNameOutputView = new RacingCarNameOutputView();
    MoveStrategy moveStrategy = new NumberCompareMoveStrategy(new RandomNumberGenerator());
    NameValidationStrategy nameValidationStrategy = new NameLengthValidationStrategy();
    WinnerCarStrategy winnerCarStrategy = new DistanceWinnerStrategy();

    RacingController racingController = new RacingController(racingCarNameInputView,
        racingCarNameOutputView,
        moveStrategy, nameValidationStrategy, winnerCarStrategy);

    racingController.startGame();
  }

}

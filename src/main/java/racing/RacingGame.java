package racing;

import racing.controller.RacingController;
import racing.domain.strategy.MoveStrategy;
import racing.domain.strategy.NumberCompareMoveStrategy;
import racing.domain.strategy.RandomNumberGenerator;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingGame {

  public static void main(String[] args) {
    RacingInputView racingCarNameInputView = new RacingInputView();
    RacingOutputView racingCarNameOutputView = new RacingOutputView();
    MoveStrategy moveStrategy = new NumberCompareMoveStrategy(new RandomNumberGenerator());

    RacingController racingController = new RacingController(racingCarNameInputView,
        racingCarNameOutputView, moveStrategy);

    racingController.startGame();
  }

}

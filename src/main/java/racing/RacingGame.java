package racing;

import racing.controller.RacingController;
import racing.domain.strategy.MoveStrategy;
import racing.domain.strategy.NumberCompareMoveStrategy;
import racing.domain.strategy.RandomNumberGenerator;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingGame {

  public static void main(String[] args) {
    RacingInputView racingInputView = new RacingInputView();
    RacingOutputView racingOutputView = new RacingOutputView();
    MoveStrategy moveStrategy = new NumberCompareMoveStrategy(new RandomNumberGenerator());

    RacingController racingController = new RacingController(racingInputView, racingOutputView,
        moveStrategy);
    racingController.startGame();
  }

}

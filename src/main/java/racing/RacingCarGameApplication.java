package racing;

import racing.api.RacingGameController;
import racing.core.RacingCarGame;
import racing.rule.OperationMoveRule;

public class RacingCarGameApplication {

  public static void main(String[] args) {
    RacingGameController racingGameController = getRacingGameController();
    racingGameController.play();
  }

  private static RacingGameController getRacingGameController() {
    return new RacingGameController(RacingCarGame.newGame(new OperationMoveRule()));
  }

}

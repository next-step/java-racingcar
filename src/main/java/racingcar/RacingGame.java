package racingcar;

import racingcar.controller.GameService;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {

  public static void main(String[] args) {
    String[] names = InputView.getUserStringInput().split(", ");
    int attemptNum = InputView.getUserNumInput();

    Game beforeGame = Game.create(Cars.create(names));
    GameService gameService = GameService.create(attemptNum, beforeGame);
    Game playedGame = gameService.proceedGame();
    ResultView resultView = ResultView.create(playedGame);
    resultView.printView();
  }
}

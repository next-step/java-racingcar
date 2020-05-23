package racingcar.controller;

import racingcar.domain.Game;
import racingcar.view.ResultView;

public class GameController {

  private int attemptNum;
  private Game game;

  private GameController(Integer attemptNum, Game game) {
    this.attemptNum = validateInputAttemptNum(attemptNum);
    this.game = game;
  }

  private Integer validateInputAttemptNum(Integer attemptNum) {
    int MINIMUM_THRESHOLD = 1;
    int MAXIMUM_THRESHOLD = 100;
    if (attemptNum < MINIMUM_THRESHOLD || attemptNum > MAXIMUM_THRESHOLD) {
      throw new IllegalArgumentException("잘못 입력하셨네요.");
    }
    return attemptNum;
  }

  public Game proceedGame() {
    for (int index = 0; index < this.attemptNum; index++) {
      game.doRace();
    }
    return this.game;
  }

  public ResultView getResults() {
    ResultView resultView = ResultView.create(this.game);
    return resultView.printView();
  }

  public int getAttemptNum() {
    return attemptNum;
  }

  public Game getGame() {
    return game;
  }

  public static GameController create(int attemptNum, Game game) {
    return new GameController(attemptNum, game);
  }
}

package study.step4;

import study.step4.model.RacingGame;
import study.step4.model.strategy.RandomMoveStrategy;
import study.step4.view.InputView;
import study.step4.view.ResultView;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    RacingGame racingGame = new RacingGame(inputView.getCarNames(), inputView.getGameRound());
    racingGame.start(new RandomMoveStrategy(), new ResultView());
  }
}

package racingcar.game;

import java.util.List;
import racingcar.domain.RacingRule;
import racingcar.domain.ScoreBoards;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGame {

  public static void main(String[] args) {

    String carNames = InputView.inputCarNames();
    int tryNum = InputView.inputTrynum();

    RacingRule racingRule = new RacingRule(carNames, tryNum);
    MovingStrategy movingStrategy = new RandomMovingStrategy();
    racingRule.play(movingStrategy);
    List<ScoreBoards> scoreBoards = racingRule.getScoreBoardsList();
    ResultView.showScores(scoreBoards);
    List<String> winners = racingRule.findWinner();
    ResultView.showWinners(winners);

  }

}

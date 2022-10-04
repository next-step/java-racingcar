package racingcar.game;

import java.util.List;
import racingcar.domain.RacingRule;
import racingcar.domain.ScoreBoards;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultViewImpl;

public class RacingCarGame {

  public static void main(String[] args) {

    String carNames = InputView.inputCarNames();
    int tryNum = InputView.inputTrynum();

    RacingRule racingRule = new RacingRule(carNames, tryNum);
    MovingStrategy movingStrategy = new RandomMovingStrategy();
    racingRule.play(movingStrategy);
    List<ScoreBoards> scoreBoards = racingRule.getScoreBoardsList();
    ResultViewImpl.showScores(scoreBoards);
    List<String> winners = racingRule.findWinner();
    ResultViewImpl.showWinners(winners);

  }

}

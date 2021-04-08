package racingcar;

import racingcar.car.strategy.RandomNumMovingStrategy;
import racingcar.input.InputView;
import racingcar.racing.Racing;
import racingcar.racing.RacingRule;
import racingcar.result.ResultView;

public class Main {

  public static void main(String[] args) throws Exception {
    InputView inputView = new InputView();
    RacingRule racingRule = inputView.requireRacingRule();
    Racing racing = new Racing(racingRule, new RandomNumMovingStrategy());
    ResultView resultView = new ResultView(racing);

    resultView.printPreRacing();
    while (racing.canTry()) {
      racing.tryMoveCars();
      resultView.printNow();
    }
    resultView.printWinner();
  }
}

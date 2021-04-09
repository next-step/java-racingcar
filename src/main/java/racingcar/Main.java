package racingcar;

import racingcar.domain.car.strategy.RandomNumMovingStrategy;
import racingcar.domain.racing.Racing;
import racingcar.domain.racing.RacingRule;
import racingcar.view.input.InputView;
import racingcar.view.result.ResultView;

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

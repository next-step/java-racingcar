package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.NormalMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
  public static void main(String[] args) {
    InputView inputView = new InputView();

    int numberOfCars = inputView.askCarCount();
    int numberOfTrials = inputView.askTrialCount();

    RacingCars racingCars = new RacingCars(numberOfCars);

    Racing racing = new Racing(racingCars);
    MoveStrategy normalMoveStrategy = new NormalMoveStrategy();
    ResultView resultView = new ResultView();

    for (int i = 0; i < numberOfTrials; i++) {
      racing.runRacingRound(normalMoveStrategy);
      resultView.printRacingRound(racing.statusOfRacing(), i);
    }
  }
}
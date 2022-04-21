package racing.controller;

import racing.domain.Cars;
import racing.domain.strategy.MoveStrategy;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingController {

  private final RacingInputView racingCarNameInputView;
  private final RacingOutputView racingCarNameOutputView;
  private final MoveStrategy moveStrategy;

  public RacingController(RacingInputView racingCarNameInputView,
      RacingOutputView racingCarNameOutputView, MoveStrategy moveStrategy) {
    this.racingCarNameInputView = racingCarNameInputView;
    this.racingCarNameOutputView = racingCarNameOutputView;
    this.moveStrategy = moveStrategy;
  }

  public void startGame() {
    String carNames = racingCarNameInputView.getRacingCarNames();
    int attemptCount = racingCarNameInputView.getRacingAttemptCount();

    racingCarNameOutputView.printResultTitle();

    Cars cars = Cars.newInstance(carNames);
    for (int i = 0; i < attemptCount; i++) {
      cars.attempt(moveStrategy);
      racingCarNameOutputView.printCarNameAndDistance(cars);
    }

    Cars winners = cars.getWinners();
    racingCarNameOutputView.printWinner(winners);

  }
}

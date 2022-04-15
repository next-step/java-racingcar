package racing.controller;

import racing.domain.Cars;
import racing.domain.strategy.MoveStrategy;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingController {

  private final RacingInputView racingInputView;
  private final RacingOutputView racingOutputView;
  private final MoveStrategy moveStrategy;

  public RacingController(RacingInputView racingInputView,
      RacingOutputView racingOutputView, MoveStrategy moveStrategy) {
    this.racingInputView = racingInputView;
    this.racingOutputView = racingOutputView;
    this.moveStrategy = moveStrategy;
  }

  public void startGame() {
    int carCount = racingInputView.getRacingCarCount();
    int attemptCount = racingInputView.getRacingAttemptCount();

    racingOutputView.printResultTitle();

    Cars cars = Cars.newInstance(carCount, moveStrategy);

    for (int i = 0; i < attemptCount; i++) {
      cars.attempt();
      racingOutputView.printCarDistance(cars);
    }
  }
}

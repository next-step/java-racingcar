package racing.controller;

import racing.domain.NamedCars;
import racing.domain.strategy.MoveStrategy;
import racing.domain.strategy.NameValidationStrategy;
import racing.domain.strategy.WinnerCarStrategy;
import racing.view.RacingCarNameInputView;
import racing.view.RacingCarNameOutputView;

public class RacingController {

  private final RacingCarNameInputView racingCarNameInputView;
  private final RacingCarNameOutputView racingCarNameOutputView;
  private final MoveStrategy moveStrategy;
  private final NameValidationStrategy nameValidationStrategy;
  private final WinnerCarStrategy winnerCarStrategy;

  public RacingController(RacingCarNameInputView racingCarNameInputView,
      RacingCarNameOutputView racingCarNameOutputView,
      MoveStrategy moveStrategy, NameValidationStrategy nameValidationStrategy,
      WinnerCarStrategy winnerCarStrategy) {
    this.racingCarNameInputView = racingCarNameInputView;
    this.racingCarNameOutputView = racingCarNameOutputView;
    this.moveStrategy = moveStrategy;
    this.nameValidationStrategy = nameValidationStrategy;
    this.winnerCarStrategy = winnerCarStrategy;
  }

  public void startGame() {
    String carNames = racingCarNameInputView.getRacingCarNames();
    int attemptCount = racingCarNameInputView.getRacingAttemptCount();

    racingCarNameOutputView.printResultTitle();

    NamedCars cars = NamedCars.newInstance(carNames, nameValidationStrategy, moveStrategy);
    for (int i = 0; i < attemptCount; i++) {
      cars.attempt();
      racingCarNameOutputView.printCarNameAndDistance(cars);
    }

    NamedCars winners = winnerCarStrategy.getWinners(cars);
    racingCarNameOutputView.printWinner(winners);

  }
}

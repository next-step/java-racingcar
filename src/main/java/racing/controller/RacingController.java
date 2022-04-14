package racing.controller;

import racing.domain.Cars;
import racing.domain.strategy.NumberCompareMoveStrategy;
import racing.domain.strategy.RandomNumberGenerator;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingController {

  public void startGame() {
    RacingInputView racingInputView = new RacingInputView();
    racingInputView.setRacingUserInput();

    RacingOutputView racingOutputView = new RacingOutputView();
    racingOutputView.printResultTitle();

    Cars cars = Cars.makeCars(racingInputView.getCarCount(),
        new NumberCompareMoveStrategy(new RandomNumberGenerator()));

    for (int i = 0; i < racingInputView.getCarCount(); i++) {
      cars.attempt();
      racingOutputView.printCarDistance(cars);
    }
  }

}

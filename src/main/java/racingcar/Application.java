package racingcar;

import racingcar.model.RacingGame;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.view.InputView;

public class Application {
  public static void main(String[] args) {
    RandomMovingStrategy movingStrategy = new RandomMovingStrategy();

    int numberOfCars = InputView.inputNumberOfRacingCars();
    int numberOfRounds = InputView.inputNumberOfRacingRounds();

    RacingGame racingGame = new RacingGame(numberOfCars, numberOfRounds, movingStrategy);
    racingGame.play();

  }

}

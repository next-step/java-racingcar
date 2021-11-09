package racingcar.model;

import racingcar.strategy.MovingStrategy;
import racingcar.view.ResultView;

public class RacingGame {

  private int numberOfCars;
  private int numberOfRound;

  private MovingStrategy movingStrategy;

  public RacingGame(int numberOfCars, int numberOfRound, MovingStrategy movingStrategy) {
    this.numberOfCars = numberOfCars;
    this.numberOfRound = numberOfRound;
    this.movingStrategy = movingStrategy;
  }

  public void play() {
    Cars cars = new Cars(numberOfCars);

    for (int i = 0; i < numberOfRound; i++) {
      cars.eachMove(movingStrategy);
      ResultView.printRacingResult(cars.getCars());
    }
  }

}

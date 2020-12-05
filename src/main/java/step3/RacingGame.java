package step3;

import step3.domain.Cars;
import step3.domain.RandomRacingRule;
import step3.view.RacingGameView;

public class RacingGame {

  public void start(int numberOfCar, int gameCount) {
    Cars cars = new Cars(numberOfCar);
    for (int i = 0; i < gameCount; i++) {
      cars.race(new RandomRacingRule());
      RacingGameView.printRacingGameResult(cars);
    }
  }

}

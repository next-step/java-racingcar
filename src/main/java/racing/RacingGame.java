package racing;

import java.util.List;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

  public void start() {
    int numberOfCar = InputView.getNumberOfRacingCar();
    int numberOfChance = InputView.getNumberOfChance();

    ResultView.printResultTitle();

    Cars cars = new Cars(numberOfCar);
    play(numberOfChance, cars);
  }

  private void play(int numberOfChance, Cars cars) {
    for (int i = 0; i < numberOfChance; i++) {
      playATurn(cars);
    }
  }

  private void playATurn(Cars cars) {
    cars.move();
    List<Integer> locations = cars.getLocations();
    ResultView.printTurnResult(locations);
  }
}

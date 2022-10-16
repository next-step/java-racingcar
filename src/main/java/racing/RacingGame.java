package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

  public void start() {
    String rawNamesOfCars = InputView.getNumberOfRacingCar();
    int numberOfChance = InputView.getNumberOfChance();

    ResultView.printResultTitle();

    String[] namesOfCars = rawNamesOfCars.split(",");

    Cars cars = new Cars(namesOfCars);
    play(numberOfChance, cars);
  }

  private void play(int numberOfChance, Cars cars) {
    for (int i = 0; i < numberOfChance; i++) {
      playATurn(cars);
    }
    ResultView.printWinners(cars);
  }

  private void playATurn(Cars cars) {
    cars.move();
    ResultView.printTurnResult(cars);
  }
}

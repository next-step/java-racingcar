package study.racingcar;

import study.racingcar.logic.RacingGame;
import study.racingcar.view.InputView;

public class Application {

  public static void main(String[] args) {
    String[] nameOfCars = InputView.inputNameOfCars();
    int numOfRaces = InputView.inputNumOfRaces();

    RacingGame racing = new RacingGame(nameOfCars, numOfRaces);
    racing.start();
  }
}

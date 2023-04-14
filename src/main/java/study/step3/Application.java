package study.step3;

import study.step3.logic.RacingGame;
import study.step3.view.InputView;

public class Application {

  public static void main(String[] args) {
    String[] nameOfCars = InputView.inputNameOfCars();
    int numOfRaces = InputView.inputNumOfRaces();

    RacingGame racing = new RacingGame(nameOfCars, numOfRaces);
    racing.start();
  }
}

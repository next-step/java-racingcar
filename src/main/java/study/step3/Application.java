package study.step3;

import study.step3.logic.RacingGame;
import study.step3.view.InputView;

public class Application {

  public static void main(String[] args) {
    int numOfCars = InputView.inputNumOfCars();
    int numOfRaces = InputView.inputNumOfRaces();

    RacingGame racing = new RacingGame(numOfCars, numOfRaces);
    racing.start();
  }
}

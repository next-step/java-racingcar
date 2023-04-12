package study.step3;

import study.step3.logic.Racing;
import study.step3.view.InputView;

public class Application {

  public static void main(String[] args) {
    int numOfCars = InputView.inputNumOfCars();
    int numOfRaces = InputView.inputNumOfRaces();

    Racing racing = new Racing(numOfCars, numOfRaces);
    racing.start();
  }
}

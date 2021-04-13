package study.step3;

import study.step3.controller.CarRace;
import study.step3.view.InputView;

public class RacingMain {
  public static void main(String[] args) {
    int carNumber = InputView.inputCarNumber();
    int times = InputView.inputTimes();

    CarRace carRace = new CarRace(carNumber, times);
    carRace.start();
  }

}

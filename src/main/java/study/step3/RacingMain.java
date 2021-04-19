package study.step3;

import study.step3.controller.CarRaceController;
import study.step3.view.InputView;

public class RacingMain {
  public static void main(String[] args) {

    String[] names = InputView.inputNames();
    int times = InputView.inputTimes();

    CarRaceController carRaceController = new CarRaceController();
    carRaceController.start(names, times);
  }

}

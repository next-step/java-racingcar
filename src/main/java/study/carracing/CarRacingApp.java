package study.carracing;

import study.carracing.controller.RacingController;
import study.carracing.ui.CarRacingResultView;
import study.carracing.ui.ScannerInputView;

public class CarRacingApp {

    public static void main(String[] args) {
        RacingController racingController = new RacingController(new ScannerInputView(), new CarRacingResultView());
        racingController.start();
    }
}

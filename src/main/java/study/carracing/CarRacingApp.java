package study.carracing;

import study.carracing.controller.RacingController;
import study.carracing.ui.ResultView;
import study.carracing.ui.ScannerInputView;

public class CarRacingApp {

    public static void main(String[] args) {
        RacingController racingController = new RacingController(new ScannerInputView(), new ResultView());
        racingController.start();
    }
}

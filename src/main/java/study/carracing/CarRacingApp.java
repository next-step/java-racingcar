package study.carracing;

import study.carracing.controller.RacingController;
import study.carracing.ui.InputView;
import study.carracing.ui.ScannerInputView;
import study.carracing.util.Validator;

public class CarRacingApp {

    public static void main(String[] args) {
        InputView inputView = new ScannerInputView();
        final int carCount = Validator.validateInput(inputView.inputCarCount());
        final int tryCount = Validator.validateInput(inputView.inputTryCount());

        RacingController racingController = new RacingController();
        racingController.start(carCount, tryCount);
    }
}

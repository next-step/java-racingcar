package study.carracing.domain;

import study.carracing.Racing;
import study.carracing.ui.InputView;

public class CarRacingController {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        Racing racing = new Racing(carCount);
        racing.start(tryCount);
    }
}

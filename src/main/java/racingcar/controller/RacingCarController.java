package racingcar.controller;

import racingcar.service.ValidationCheck;
import racingcar.service.Racing;
import racingcar.view.InputView;

public class RacingCarController {

    public static void main(String[] args) {

        int carCount = ValidationCheck.checkInputCarCount(InputView.inputCarCount());
        int tryCount = ValidationCheck.checkInputCarCount(InputView.inputTryCount());

        Racing racing = new Racing();
        racing.startRacing(carCount, tryCount);
    }
}

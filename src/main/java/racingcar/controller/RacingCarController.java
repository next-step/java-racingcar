package racingcar.controller;

import racingcar.service.ValidationCheck;
import racingcar.service.Racing;
import racingcar.view.InputView;

public class RacingCarController {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        int carCount = ValidationCheck.checkInputCarCount(inputView.inputCarCount());
        int tryCount = ValidationCheck.checkInputCarCount(inputView.inputTryCount());

        Racing racing = new Racing();
        racing.startRacing(carCount, tryCount);
    }
}

package racingcar.controller;

import racingcar.service.ValidationCheck;
import racingcar.service.Racing;
import racingcar.view.InputView;

public class RacingCarController {

    public static void main(String[] args) {
        String inputCarNames = InputView.inputCarNames();
        int tryCount = ValidationCheck.checkInputTryCount(InputView.inputTryCount());

        Racing racing = new Racing();
        racing.startRacing(inputCarNames, tryCount);
    }
}

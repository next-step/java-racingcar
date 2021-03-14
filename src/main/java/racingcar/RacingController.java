package racingcar;

import racingcar.controller.RacingMachine;
import racingcar.view.InputView;

public class RacingController {

    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int numberOfRound = InputView.getNumberOfRound();
        RacingMachine.runMachine(carNames, numberOfRound);
    }
}

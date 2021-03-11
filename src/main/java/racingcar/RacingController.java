package racingcar;

import racingcar.domain.RacingMachine;
import racingcar.util.InputView;

public class RacingController {

    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int numberOfRound = InputView.getNumberOfRound();
        RacingMachine.runMachine(carNames, numberOfRound);
    }
}

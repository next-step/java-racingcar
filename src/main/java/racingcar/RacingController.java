package racingcar;

import racingcar.domain.RacingMachine;
import racingcar.util.InputView;

public class RacingController {

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCar();
        int numberOfRound = InputView.getNumberOfRound();
        RacingMachine.runMachine(numberOfCars, numberOfRound);
    }
}

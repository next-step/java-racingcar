package racingcar.controller;

import racingcar.behavior.RandomMovingStrategy;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
    public static void main(String[] args) {
        String[] nameOfCars = InputView.inputNameOfCars();
        int loopCount = InputView.inputLoopCount();

        RacingCars racingCars = RacingCars.of(nameOfCars, new RandomMovingStrategy(), round);
        ResultView.printResultMessage();
        while (!round.isLastRound()) {
            ResultView.printPositionResult(round.progressRound(racingCars));
        }
        ResultView.printNamesOfWinnerCarsResult(racingCars.getNamesOfWinnerCars());
    }
}

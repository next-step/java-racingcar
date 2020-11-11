package racingcar.controller;


import racingcar.behavior.RandomMovingStrategy;
import racingcar.domain.RacingCars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
    public static void main(String[] args) {
        String[] nameOfCars = InputView.inputNameOfCars();
        int loopCount = InputView.inputLoopCount();
        Round round = new Round(loopCount);

        RacingCars racingCars = RacingCars.of(nameOfCars, new RandomMovingStrategy(), round);
        ResultView.printResultMessage();
        round.progressRound(racingCars);
    }
}

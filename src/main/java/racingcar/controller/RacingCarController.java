package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    public static void start() {
        RacingCars racingCars = RacingCars.create(InputView.inputCarCount());
        Round round = Round.create(InputView.inputAttemptCount());

        while (round.checkRound()) {
            racingCars.move();
            ResultView.printStatus(racingCars);
            round = round.decrease();
        }
    }
}

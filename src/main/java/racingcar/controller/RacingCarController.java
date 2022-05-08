package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.model.RacingGame;
import racingcar.model.Round;
import racingcar.view.InputView;

public class RacingCarController {
    public static void start() {
        RacingCars racingCars = RacingCars.create(InputView.inputCarName());
        Round round = Round.create(InputView.inputAttemptCount());
        RacingGame.start(racingCars, round);
    }
}

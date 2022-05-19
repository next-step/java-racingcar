package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.Round;
import racingcar.view.InputView;

public class RacingCarController {
    public static void start() {
        RacingCars racingCars = RacingCars.create(InputView.inputCarName());
        Round round = Round.create(InputView.inputAttemptCount());
        RacingGame.start(racingCars, round);
    }
}

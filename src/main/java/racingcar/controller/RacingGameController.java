package racingcar.controller;

import racingcar.dto.RaceResult;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController(final RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run() {
        String carNames = InputView.getCarCount();
        int attemptCount = InputView.getAttemptCount();

        RaceResult raceResult = racingGameService.play(carNames, attemptCount);

        ResultView.print(raceResult);
    }
}

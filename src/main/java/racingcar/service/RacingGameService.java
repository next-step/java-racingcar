package racingcar.service;

import racingcar.domain.*;
import racingcar.dto.RaceResult;

public class RacingGameService {

    private final RacingGame racingGame;

    public RacingGameService(final RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public RaceResult play(final String carNames, final int attemptCount) {
        return racingGame.play(carNames, attemptCount);
    }
}

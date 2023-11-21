package racingcar.service;

import racingcar.domain.NumberOfAttempts;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomService;
import racingcar.dto.GameResultInfo;

public class RacingCarService {
    private final RacingGame racingGame;

    public RacingCarService(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public GameResultInfo startGame(RacingCars racingCars, NumberOfAttempts numberOfAttempts) {
        return racingGame.startSingleGame(racingCars, numberOfAttempts);
    }
}

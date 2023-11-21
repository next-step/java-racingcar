package racingcar.service;

import racingcar.domain.NumberOfAttempts;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomService;
import racingcar.dto.GameResultInfo;

public class RacingCarService {

    private final RandomService randomService;

    public RacingCarService(RandomService randomService) {
        this.randomService = randomService;
    }

    public GameResultInfo startGame(RacingCars racingCars, NumberOfAttempts numberOfAttempts) {
        return createRacingGame(racingCars, numberOfAttempts).startSingleGame();
    }

    private RacingGame createRacingGame(RacingCars racingCars, NumberOfAttempts numberOfAttempts) {
        return new RacingGame(randomService, racingCars, numberOfAttempts);
    }
}

package racingcar.domain;

import racingcar.dto.GameResultInfo;

public class RacingGame {
    private final RandomService randomService;

    public RacingGame(RandomService randomService) {
        this.randomService = randomService;
    }

    public GameResultInfo startSingleGame(RacingCars racingCars, NumberOfAttempts numberOfAttempts) {
        return GameResultInfo.valueOf(getGameResult(racingCars), getLeftNumberOfAttempts(numberOfAttempts));
    }

    private RacingCars getGameResult(RacingCars racingCars) {
        return racingCars.raceOnce(randomService);
    }

    private NumberOfAttempts getLeftNumberOfAttempts(NumberOfAttempts numberOfAttempts) {
        return numberOfAttempts.attempt();
    }
}

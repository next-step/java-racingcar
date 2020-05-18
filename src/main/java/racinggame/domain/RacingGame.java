package racinggame.domain;

import racinggame.domain.car.RacingCars;
import racinggame.domain.result.RacingGameResult;
import racinggame.dto.RacingGameInfo;

public class RacingGame {
    private final RacingCars racingCars;
    private final int totalRound;

    public RacingGame(RacingGameInfo racingGameInfo) {
        this.racingCars = new RacingCars(racingGameInfo.getCarNames());
        this.totalRound = racingGameInfo.getTotalRound();
    }

    public RacingGameResult raceWith(Engine engine) {
        RacingGameResult racingGameResult = new RacingGameResult(totalRound);
        int currentRound = 1;

        while (isRemainingRacingGame(currentRound)) {
            racingGameResult.record(currentRound, racingCars.race(engine));
            currentRound++;
        }

        return racingGameResult;
    }

    private boolean isRemainingRacingGame(int currentRound) {
        return currentRound <= totalRound;
    }
}

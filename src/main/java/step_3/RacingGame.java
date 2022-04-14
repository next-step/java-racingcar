package step_3;

import java.util.stream.IntStream;

public class RacingGame {

    private final int totalRounds;
    private final RacingCars racingCars;

    public RacingGame(RacingGameConditions racingGameConditions) {
        this.totalRounds = racingGameConditions.getTotalRounds();
        this.racingCars = new RacingCars(racingGameConditions.getTotalRounds(), racingGameConditions.getTotalRacingCarCount());
    }

    public void gameStart() {
        IntStream.range(0, totalRounds)
                .forEach(thisRound -> {
                    this.racingCars.roundFight(thisRound);
                    GameHost.presentation(this.racingCars.forwardHistoriesByRound());
                });
    }
}

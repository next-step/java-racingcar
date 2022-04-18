package step_3.controller;

import step_3.domain.RacingCars;
import step_3.model.GameCondition;
import step_3.model.GameResult;

import java.util.stream.Stream;

public class RacingGame {

    private final int totalRounds;
    private final RacingCars racingCars;

    public RacingGame(GameCondition gameCondition) {
        this.totalRounds = gameCondition.getTotalRounds();
        this.racingCars = new RacingCars(gameCondition.getTotalRacingCarCount());
    }

    public GameResult gameStart() {
        return Stream.generate(this.racingCars::roundFight)
                .limit(totalRounds)
                .collect(GameResult::new, GameResult::record, GameResult::record);
    }
}

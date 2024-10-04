package racinggame.domain;

import static racinggame.domain.RacingGameRules.MIN_RACING_CAR_COUNT;

public class RacingGame {
    private final RacingCars racingCars;
    private final int roundCount;

    public RacingGame(final RacingCars racingCars, final int roundCount) {
        this.racingCars = racingCars;
        this.roundCount = roundCount;
    }

    public RacingGameResults play() {
        if (racingCars.size() < MIN_RACING_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 최소 " + MIN_RACING_CAR_COUNT + "대 이상이여야 합니다.");
        }

        final RacingGameResults results = new RacingGameResults();
        for (int i = 0; i < roundCount; i++) {
            final RacingGameResult racingGameResult = new RacingGameResult(racingCars.moves());
            results.add(racingGameResult);
        }

        return results;
    }
}

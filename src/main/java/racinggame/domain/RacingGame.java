package racinggame.domain;

import static racinggame.domain.RacingCars.MIN_RACING_CAR_COUNT;

public class RacingGame {
    public static final int MIN_RACING_ROUND_COUNT = 1;

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

        if (roundCount < MIN_RACING_ROUND_COUNT) {
            throw new IllegalArgumentException("라운드는 최소 " + MIN_RACING_ROUND_COUNT + "이상이여야 합니다.");
        }

        final RacingGameResults results = new RacingGameResults();
        RacingCars currentCars = racingCars;
        for (int i = 0; i < roundCount; i++) {
            currentCars = currentCars.moves();
            final RacingGameResult racingGameResult = new RacingGameResult(currentCars);
            results.add(racingGameResult);
        }

        return results;
    }
}

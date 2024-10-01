package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<RacingCar> racingCars;
    private final int roundCount;

    public RacingGame(final List<RacingCar> racingCars, final int roundCount) {
        this.racingCars = racingCars;
        this.roundCount = roundCount;
    }

    public List<RacingGameResult> play() {
        return processRounds();
    }

    private List<RacingGameResult> processRounds() {
        final List<RacingGameResult> results = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            final RacingGameResult racingGameResult = new RacingGameResult(moveCars());
            results.add(racingGameResult);
        }

        return results;
    }

    private List<Integer> moveCars() {
        final List<Integer> results = new ArrayList<>();
        for (final RacingCar car : racingCars) {
            car.move();
            results.add(car.currentPosition());
        }
        return results;
    }
}

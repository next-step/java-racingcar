package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RandomNumber randomNumber;

    private static final int MIN_ROUND = 1;

    public RacingGame(Cars cars, RandomNumber randomNumber) {
        this.cars = cars;
        this.randomNumber = randomNumber;
    }

    public List<List<Integer>> race(int roundCount) {
        validateRoundCount(roundCount);

        List<List<Integer>> raceHistory = new ArrayList<>();

        for (int round = 0; round < roundCount; round++) {
            executeRound();
            raceHistory.add(getCurrentPositions());
        }

        return raceHistory;
    }

    private void validateRoundCount(int roundCount) {
        if (isInvalidRoundCount(roundCount)) {
            throw new IllegalArgumentException("라운드 수는 1이상이어야 합니다.");
        }
    }

    private boolean isInvalidRoundCount(int roundCount) {
        return roundCount < MIN_ROUND;
    }

    private List<Integer> getCurrentPositions() {
        return cars.getDistances();
    }

    private void executeRound() {
        cars.moveAll(randomNumber);
    }
}

package racingcar.domain.round;

import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class Rounds {
    private static final int MIN_ROUND_COUNT = 1;

    private final int roundCount;
    private final Cars cars;

    public Rounds(Cars cars, int roundCount) {
        validateRounds(cars, roundCount);
        this.roundCount = roundCount;
        this.cars = cars;
    }

    private void validateRounds(Cars cars, int roundCount) {
        if (cars == null) {
            throw new IllegalArgumentException("cars는 null일 수 없습니다.");
        }

        if (roundCount < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException(String.format("Rounds는 최소 %d회 이상이어야 합니다.", MIN_ROUND_COUNT));
        }
    }

    public List<Round> play() {
        Round currentRound = new Round(cars);
        List<Round> roundResults = new ArrayList<>();

        for (int i = 0; i < roundCount; i++) {
            currentRound = currentRound.play();
            roundResults.add(currentRound);
        }

        return roundResults;
    }
}

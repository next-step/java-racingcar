package racingcar.domain.round;

import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class Rounds {
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

        if (roundCount < 1) {
            throw new IllegalArgumentException("Rounds는 최소 1회 이상이어야 합니다.");
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

package racingcar.domain;

import racingcar.dto.RoundResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {

    private static final String INVALID_ATTEMPT_COUNT_MESSAGE = "시도 횟수는 1 이상이어야 합니다.";
    private final Cars cars;
    private final int attemptCount;

    private RacingCar(Cars cars, int attemptCount) {
        validate(attemptCount);
        this.cars = cars;
        this.attemptCount = attemptCount;
    }


    public static RacingCar from(Cars cars, int attemptCount) {
        return new RacingCar(cars, attemptCount);
    }

    public List<RoundResult> race(RandomMoveStrategy strategy) {
        List<RoundResult> results = new ArrayList<>();
        for (int i = 0; i < attemptCount; i++) {
            cars.moveCars(strategy);
            results.add(RoundResult.from(cars));
        }
        return results;
    }


    private void validate(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_MESSAGE);
        }
    }
}

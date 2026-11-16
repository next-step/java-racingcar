package racingcar.domain;

import racingcar.dto.RoundResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {

    private static final String INVALID_ATTEMPT_COUNT_MESSAGE = "시도 횟수는 1 이상이어야 합니다.";
    private final Car[] cars;
    private final int attemptCount;

    public RacingCar(Car[] cars, int attemptCount) {
        validate(attemptCount);
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public List<RoundResult> race(RandomMoveStrategy strategy) {

        List<RoundResult> results = new ArrayList<>();
        for (int i = 0; i < attemptCount; i++) {
            moveCar(strategy);
            results.add(RoundResult.from(this));
        }

        return results;
    }

    private void moveCar(RandomMoveStrategy strategy) {
        for (int j = 0; j < cars.length; j++) {
            tryMove(strategy, cars[j]);
        }
    }

    private void tryMove(RandomMoveStrategy strategy, Car car) {
        car.moveForward(strategy);
    }

    public List<Position> getPositions() {
        return Arrays.stream(cars)
                .map(Car::getPosition)
                .toList();
    }


    private void validate(int attemptCount) {
        if (attemptCount < 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_MESSAGE);
        }
    }
}

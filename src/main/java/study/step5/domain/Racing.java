package study.step5.domain;

import java.util.List;

public class Racing {

    private static final int ATTEMPT_FINISH = 0;
    private static final int ATTEMPT_NUMBER_MIN = 1;
    private static final String ATTEMPT_NUMBER_MIN_ERROR = "시도횟수는 최소 1회 이상이어야 합니다.";

    private final Cars cars;
    private int attemptNumber;
    private final MoveBehavior moveBehavior;

    private Racing(final Cars cars, int attemptNumber, final MoveBehavior moveBehavior) {
        if (attemptNumber < ATTEMPT_NUMBER_MIN) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_MIN_ERROR);
        }
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        this.moveBehavior = moveBehavior;
    }

    public static Racing of(final Cars cars, final int attemptNumber, final MoveBehavior moveBehavior) {
        return new Racing(cars, attemptNumber, moveBehavior);
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public Cars getCars() {
        return cars;
    }

    public boolean isFinished() {
        return ATTEMPT_FINISH >= attemptNumber;
    }

    public void race() {
        attemptNumber--;
        cars.move(moveBehavior);
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}

package study.step5.domain;


public class Racing {

    private static final int ATTEMPT_NUMBER_MIN = 1;
    private static final String ATTEMPT_NUMBER_MIN_ERROR = "시도횟수는 최소 1회 이상이어야 합니다.";

    private final Cars cars;
    private final int attemptNumber;
    private int attemptCount;

    private Racing(final Cars cars, final int attemptNumber) {
        if (attemptNumber < ATTEMPT_NUMBER_MIN) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_MIN_ERROR);
        }
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        this.attemptCount = 0;
    }

    public static Racing of(final Cars cars, final int attemptNumber) {
        return new Racing(cars, attemptNumber);
    }


}

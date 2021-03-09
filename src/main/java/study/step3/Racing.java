package study.step3;

public class Racing {

    private final Cars cars;
    private final int attemptNumber;
    private int attemptCount;

    private Racing(final Cars cars, final int attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        this.attemptCount = 0;
    }

    public static Racing of(final Cars cars, final int attemptNumber) {
        return new Racing(cars, attemptNumber);
    }

    public boolean isFinshed() {
        return attemptCount >= attemptNumber ? true : false;
    }
}


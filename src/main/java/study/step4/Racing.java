package study.step4;

public class Racing {

    private final Cars cars;
    private final int attemptNumber;
    private int attemptCount;
    private final MoveBehavior moveBehavior;

    private Racing(final Cars cars, final int attemptNumber, final MoveBehavior moveBehavior) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        this.attemptCount = 0;
        this.moveBehavior = moveBehavior;
    }

    public static Racing of(final Cars cars, final int attemptNumber, final MoveBehavior moveBehavior) {
        return new Racing(cars, attemptNumber, moveBehavior);
    }

    public Cars getCars() {
        return cars;
    }

    public boolean isFinished() {
        return attemptCount >= attemptNumber;
    }

    public Cars race() {
        attemptCount++;
        return cars.move(moveBehavior);
    }
}

package study.step4;

import java.util.stream.Collectors;

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

    public void race() {
        attemptCount++;
        cars.move(moveBehavior);
    }

    public String getWinners() {
        int maxLocation = cars.stream()
                .map(car -> car.getLocation())
                .max(Integer::compare)
                .get();

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(car -> car.getCarName())
                .collect(Collectors.joining(RacingConstant.COMMA));
    }
}

package study.step3;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final Cars cars;
    private final int attemptNumber;
    private int attemptCount;

    private Racing(final Cars cars, final int attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        this.attemptCount = 0;
    }

    public boolean isFinished() {
        return attemptCount >= attemptNumber;
    }

    public List<Car> race() {
        attemptCount++;

        return cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());
    }

    public static Racing of(final Cars cars, final int attemptNumber) {
        return new Racing(cars, attemptNumber);
    }
}


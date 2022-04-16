package racingcar;

public class Rule {
    private final RacingCars cars;
    private final int maxAttempts;

    public Rule(RacingCars cars, int maxAttempts) {
        this.cars = cars;
        this.maxAttempts = maxAttempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public RacingCars getCars() {
        return cars;
    }
}

package carracing.model;

import static carracing.RacingGameSetupValidator.isPositiveInteger;

public class NumberOfCars {
    private static final String WRONG_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 양의 정수만 가능합니다.";

    private final int numberOfCars;

    private NumberOfCars(final String numberOfCars) {
        if (!isPositiveInteger(numberOfCars)) {
            throw new IllegalArgumentException(WRONG_NUMBER_OF_CARS_MESSAGE);
        }
        this.numberOfCars = Integer.parseInt(numberOfCars);
    }

    public static NumberOfCars newNumber(final String numberOfCars) {
        return new NumberOfCars(numberOfCars);
    }

    public int numberOfCars() {
        return numberOfCars;
    }
}

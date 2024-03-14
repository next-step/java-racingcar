package carracing.domain;

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

    private NumberOfCars(final int numberOfCars) {
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException(WRONG_NUMBER_OF_CARS_MESSAGE);
        }
        this.numberOfCars = numberOfCars;
    }

    public static NumberOfCars newNumber(final String numberOfCars) {
        return new NumberOfCars(numberOfCars);
    }

    public static NumberOfCars newNumber(final int numberOfCars) {
        return new NumberOfCars(numberOfCars);
    }

    public int numberOfCars() {
        return numberOfCars;
    }
}

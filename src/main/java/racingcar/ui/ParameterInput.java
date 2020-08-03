package racingcar.ui;

public class ParameterInput extends RacingDataInput {

    private final int numberOfCars;
    private final int tryCount;

    public ParameterInput(int numberOfCars, int tryCount) {
        this.numberOfCars = numberOfCars;
        this.tryCount = tryCount;
    }

    @Override
    int inputNumberOfCars() {
        return numberOfCars;
    }

    @Override
    int inputTryCount() {
        return tryCount;
    }
}

package racingcar.ui;

public class ParameterInput extends RacingDataInput {

    private final String names;
    private final int numberOfCars;
    private final int tryCount;

    public ParameterInput(String names, int numberOfCars, int tryCount) {
        this.names = names;
        this.numberOfCars = numberOfCars;
        this.tryCount = tryCount;
    }

    @Override
    public String inputNames() {
        return names;
    }

    @Override
    public int inputNumberOfCars() {
        return numberOfCars;
    }

    @Override
    public int inputTryCount() {
        return tryCount;
    }
}

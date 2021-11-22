package racingcar.view;

public class InputResult {
    private final int numberOfCars;
    private final int numberOfTries;

    public InputResult(int numberOfCars, int numberOfTries) {
        this.numberOfCars = numberOfCars;
        this.numberOfTries = numberOfTries;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }
}

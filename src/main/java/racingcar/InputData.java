package racingcar;

public class InputData {
    private int numberOfCars;
    private int tryCount;

    public InputData(int numberOfCars, int tryCount) {
        this.numberOfCars = numberOfCars;
        this.tryCount = tryCount;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTryCount() {
        return tryCount;
    }
}

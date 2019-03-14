package racingcar.application;

public class InputView {
    private final int numberOfCars;
    private final int time;

    public InputView(final int numberOfCars, final int time) {
        this.numberOfCars = numberOfCars;
        this.time = time;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTime() {
        return time;
    }
}

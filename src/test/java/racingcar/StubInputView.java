package racingcar;

import racingcar.view.InputView;

public class StubInputView extends InputView {
    private final int numberOfCars;
    private final int attemptCount;

    public StubInputView(int numberOfCars, int attemptCount) {
        this.numberOfCars = numberOfCars;
        this.attemptCount = attemptCount;
    }

    @Override
    public void initGameInput() {
    }

    @Override
    public int getNumberOfCars() {
        return numberOfCars;
    }

    @Override
    public int getAttemptCount() {
        return attemptCount;
    }
}

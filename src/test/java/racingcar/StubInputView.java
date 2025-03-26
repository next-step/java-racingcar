package racingcar;

import racingcar.view.InputView;

public class StubInputView extends InputView {
    private final String[] carNames;
    private final int attemptCount;

    public StubInputView(String[] carNames, int attemptCount) {
        this.carNames = carNames;
        this.attemptCount = attemptCount;
    }

    @Override
    public void initGameInput() {
    }

    @Override
    public String[] getCarNames() {
        return carNames;
    }

    @Override
    public int getAttemptCount() {
        return attemptCount;
    }
}

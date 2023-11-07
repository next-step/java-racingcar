package study.carracing.ui;

public class TestInputView implements InputView {

    private final int carCount;
    private final int tryCount;

    public TestInputView(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    @Override
    public int inputCarCount() {
        return carCount;
    }

    @Override
    public int inputTryCount() {
        return tryCount;
    }
}

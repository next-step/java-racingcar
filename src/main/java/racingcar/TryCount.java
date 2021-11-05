package racingcar;

public class TryCount {
    private static final int COUNT_ONE = 1;
    private static final int COUNT_ZERO = 0;

    private int tryCount;

    private TryCount(int tryCount) {
        validateCount(tryCount);
        this.tryCount = tryCount;
    }

    private void validateCount(int tryCount) {
        if (tryCount < COUNT_ONE) {
            throw new TryCountException(tryCount);
        }
    }

    public static TryCount from(int tryCount) {
        return new TryCount(tryCount);
    }

    public boolean nonOver() {
        return this.tryCount != COUNT_ZERO;
    }

    public void counting() {
        this.tryCount -= COUNT_ONE;
    }
}

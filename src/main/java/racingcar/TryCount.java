package racingcar;

public class TryCount {
    private static final int COUNT_ONE = 1;

    private int tryCount;

    private TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCount from(int tryCount) {
        return new TryCount(tryCount);
    }

    public boolean isDone() {
        return this.tryCount == 0;
    }

    public void counting() {
        this.tryCount -= COUNT_ONE;
    }
}

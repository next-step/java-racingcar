package racingcar;

public class TryCount {
    private static final int COUNT_ONE = 1;

    private int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }


    public boolean isDone() {
        return this.tryCount == 0;
    }

    public void counting() {
        this.tryCount -= COUNT_ONE;
    }
}

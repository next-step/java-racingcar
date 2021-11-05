package racingcar;

public class TryCount {
    private final int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }


    public boolean isDone() {
        return this.tryCount == 0;
    }
}

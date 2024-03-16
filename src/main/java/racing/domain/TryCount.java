package racing.domain;

public class TryCount {
    private int tryCount;

    private TryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }

        this.tryCount = tryCount;
    }

    public static TryCount valueOf(int tryCount) {
        return new TryCount(tryCount);
    }

    public void decrement() {
        tryCount--;
    }

    public boolean hasLeft() {
        return tryCount > 0;
    }
}

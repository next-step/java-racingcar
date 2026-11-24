package racingcar.domain;

public class TryCount {
    private int count;

    public TryCount(int count) {
        validatePositive(count);
        this.count = count;
    }

    private static void validatePositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("try count must be positive [" + count + "]");
        }
    }

    public void decrease() {
        if (!hasRemaining()) {
            throw new IllegalStateException("no remaining try count");
        }
        count--;
    }

    public boolean hasRemaining() {
        return count > 0;
    }
}

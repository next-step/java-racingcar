package car.domain;

public final class TryCount {

    private int tryCount;

    public TryCount(final int count) {
        validateNumber(count);
        this.tryCount = count;
    }

    private void validateNumber(final int num) {
        if (num < 0) {
            throw new IllegalArgumentException("시도 횟수가 음수입니다.");
        }
    }

    public boolean isPositive() {
        return this.tryCount > 0;
    }

    public void decreaseCount() {
        this.tryCount = this.tryCount - 1;
    }
}

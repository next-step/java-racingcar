package car.domain.model;

public final class Count {

    private int tryCount;

    public Count(final int count) {
        this.tryCount = validatePositive(count);
    }

    private int validatePositive(final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("양수로 입력해 주세요");
        }
        return count;
    }

    public void decreaseTryCount() {
        tryCount--;
    }

    public boolean isRacingRemain() {
        return (tryCount > 0);
    }

}

package car.domain.model;

public final class Count {

    private int tryCount;

    public Count(final int userInputCount) {
        this.tryCount = validatePositive(userInputCount);
    }

    private int validatePositive(final int userInputCount) {
        if (userInputCount < 0) {
            throw new IllegalArgumentException("양수로 입력해 주세요");
        }
        return userInputCount;
    }

    public void decreaseTryCount() {
        tryCount--;
    }

    public boolean isRacingRemain() {
        return (tryCount > 0);
    }

}

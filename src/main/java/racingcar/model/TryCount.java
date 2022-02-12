package racingcar.model;

public class TryCount {

    private static final String TRY_COUNT_LESS_THAN_ZERO = "[ERROR] 시도 횟수는 1회 이상이어야 합니다.";
    private static final int MINIMUM_TRY_COUNT = 1;
    private static final int ZERO = 0;
    private int tryCount;

    public TryCount(int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void validateTryCount(int tryCountInput) {
        if (tryCountInput < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_LESS_THAN_ZERO);
        }
    }

    public boolean isPlaying() {
        return tryCount > ZERO;
    }

    public void decreaseTryCount() {
        this.tryCount--;
    }
}

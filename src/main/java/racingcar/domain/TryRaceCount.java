package racingcar.domain;

public class TryRaceCount {

    private static final int STOP_GAME_NUM = 0;
    private static final String INVALID_RANGE_TRY_NUM = "시도 횟수의 범위가 적절하지 않습니다.";

    private int tryCount;

    public TryRaceCount(int tryRaceCount) {
        validateCountRange(tryRaceCount);
        this.tryCount = tryRaceCount;
    }

    private void validateCountRange(int tryCount) {
        if (tryCount < STOP_GAME_NUM) {
            throw new IllegalArgumentException(INVALID_RANGE_TRY_NUM);
        }
    }

    public boolean isOngoing() {
        return tryCount > STOP_GAME_NUM;
    }

    public void runOneStep() {
        tryCount--;
    }
}

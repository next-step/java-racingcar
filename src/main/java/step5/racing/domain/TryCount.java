package step5.racing.domain;

public class TryCount {

    private static final String INVALID_TRY_COUNT_MESSAGE = "시도 회수는 양수여야 합니다.";

    private int tryCount;

    public TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }
    }
}

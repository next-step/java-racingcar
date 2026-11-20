package racingcar.domain;

public class AttemptCount {

    private static final String INVALID_ATTEMPT_COUNT_MESSAGE = "시도 횟수는 1 이상이어야 합니다.";

    private int remaining;

    public AttemptCount(int value) {
        validate(value);
        this.remaining = value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_MESSAGE);
        }
    }

    public boolean hasRemaining() {
        return remaining > 0;
    }

    public void decrease() {
        remaining--;
    }
}


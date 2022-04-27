package domain;

import java.util.Objects;

public class AttemptCount {
    private static final String WRONG_ATTEMPT_COUNT_MESSAGE = "시도 횟수는 1이상의 정수여야 합니다.";
    private static final String CORRECT_INPUT_PATTERN = "[0-9]*";
    private static final int MIN_ATTEMPT_COUNT = 1;
    private final int count;

    public AttemptCount(String count) {
        validateAttemptCount(count);
        this.count = Integer.parseInt(count);
    }

    public AttemptCount(int count) {
        validateAttemptCount(count);
        this.count = count;
    }

    public int getAttemptCount() {
        return count;
    }

    private void validateAttemptCount(int count) {
        if (count < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(WRONG_ATTEMPT_COUNT_MESSAGE);
        }
    }

    private void validateAttemptCount(String count) {
        if (count == null || !count.matches(CORRECT_INPUT_PATTERN)) {
            throw new IllegalArgumentException(WRONG_ATTEMPT_COUNT_MESSAGE);
        }
        validateAttemptCount(Integer.parseInt(count));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AttemptCount that = (AttemptCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}

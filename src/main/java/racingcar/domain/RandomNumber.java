package racingcar.domain;

public record RandomNumber(int value) {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int FORWARD_THRESHOLD = 4;

    public RandomNumber {
        validate(value);
    }

    private void validate(int value) {
        if (isOutOfRange(value)) {
            throw new IllegalArgumentException("랜덤 값은 0 이상 9 이하이어야 합니다.");
        }
    }

    private boolean isOutOfRange(int value) {
        return value < MIN_RANDOM_VALUE || value > MAX_RANDOM_VALUE;
    }

    public boolean canMoveForward() {
        return value >= FORWARD_THRESHOLD;
    }
}

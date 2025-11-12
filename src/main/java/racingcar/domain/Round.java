package racingcar.domain;

public record Round(int value) {
    private static final int MIN_ROUND = 1;

    public Round {
        validate(value);
    }

    private void validate(int value) {
        if (value < MIN_ROUND) {
            throw new IllegalArgumentException("라운드 수는 1이상이어야 합니다.");
        }
    }
}

package racingcar.domain;

public record CarName(String value) {
    private static final int MAX_NAME_LENGTH = 5;

    public CarName {
        validateNotBlank(value);
        validateLength(value);
    }

    private void validateNotBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateLength(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %d자를 초과할 수 없습니다.", MAX_NAME_LENGTH));
        }
    }
}

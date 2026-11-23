package racingcar.domain;

public record CarName(String value) {
    private static final int MAX_LENGTH = 5;

    public CarName {
        validateNotBlank(value);
        validateLength(value);
    }

    private static void validateNotBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("valid name is required [" + value + "]");
        }
    }

    private static void validateLength(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("too long for name [" + value + "]");
        }
    }
}

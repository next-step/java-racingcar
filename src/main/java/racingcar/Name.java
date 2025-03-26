package racingcar;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LONG_NAME);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}

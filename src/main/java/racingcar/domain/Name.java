package racingcar.domain;

public final class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String NOT_VALID_NAME_LENGTH_MESSAGE = "이름은 정해진 길이를 넘을 수 없습니다.";
    private final String name;

    private Name(final String name) {
        validate(name);
        this.name = name;
    }

    public static Name from(final String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(NOT_VALID_NAME_LENGTH_MESSAGE);
        }
    }
}

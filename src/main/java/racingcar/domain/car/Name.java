package racingcar.domain.car;

public class Name {

    private static final int MAXIMUM_ALLOWED_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름이 " + MAXIMUM_ALLOWED_NAME_LENGTH + "자를 초과합니다.";

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(final String name) {
        if (name.length() > MAXIMUM_ALLOWED_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
    }
}

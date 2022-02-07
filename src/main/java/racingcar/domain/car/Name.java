package racingcar.domain.car;

public class Name {

    private static final int MAXIMUM_ALLOWED_NAME_LENGTH = 5;
    private static final int MINIMUM_ALLOWED_NAME_LENGTH = 1;
    private static final String OVER_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름이 " + MAXIMUM_ALLOWED_NAME_LENGTH + "자를 초과합니다.";
    private static final String UNDER_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름이 " + MAXIMUM_ALLOWED_NAME_LENGTH + "자를 넘어가지 않습니다.";

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.length() > MAXIMUM_ALLOWED_NAME_LENGTH) {
            throw new IllegalArgumentException(OVER_NAME_LENGTH_ERROR_MESSAGE);
        }
        if (name.length() < MINIMUM_ALLOWED_NAME_LENGTH) {
            throw new IllegalArgumentException(UNDER_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
    }
}

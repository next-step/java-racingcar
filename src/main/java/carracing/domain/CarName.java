package carracing.domain;

public class CarName {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_EXCEPTION_MESSAGE_FORMAT = "자동차 이름이 유효하지 않습니다. name: %s";

    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        validateNameLength(name);
        return new CarName(name);
    }

    private static void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME_LENGTH_EXCEPTION_MESSAGE_FORMAT, name));
        }
    }
}

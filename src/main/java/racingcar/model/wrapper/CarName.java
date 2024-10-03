package racingcar.model.wrapper;

import racingcar.exception.CarNameException;

public class CarName {
    public static final int MAX_NAME_LENGTH = 5;
    public static final String NOT_ALLOWED_EMPTY_NAME = "자동차 이름은 빈값일 수 없습니다.";
    public static final String NOT_ALLOWED_EXCEED_MAX_NAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다.";
    private final String name;

    public CarName(final String name) {
        if (isEmpty(name)) {
            throw new CarNameException(NOT_ALLOWED_EMPTY_NAME);
        }
        if (isExceedMaxNameLength(name)) {
            throw new CarNameException(NOT_ALLOWED_EXCEED_MAX_NAME_LENGTH);
        }
        this.name = name;
    }

    private static boolean isExceedMaxNameLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private static boolean isEmpty(String name) {
        return name == null ||
                name.trim().isEmpty();
    }
}

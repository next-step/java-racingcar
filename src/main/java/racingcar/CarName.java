package racingcar;

import java.util.Objects;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_BLANK_NAME = "자동차 이름은 비어있을 수 없습니다.";
    private static final String ERROR_NAME_TOO_LONG = "자동차 이름은 5자를 초과할 수 없습니다.";

    private final String value;

    public CarName(String value) {
        validateName(value);
        this.value = value;
    }

    private static void validateName(String name) {
        if (isNullOrBlank(name)) {
            throw new IllegalArgumentException(ERROR_BLANK_NAME);
        }
        if (isExceedMaxLength(name)) {
            throw new IllegalArgumentException(ERROR_NAME_TOO_LONG);
        }
    }

    private static boolean isNullOrBlank(String name) {
        return name == null || name.isBlank();
    }

    private static boolean isExceedMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

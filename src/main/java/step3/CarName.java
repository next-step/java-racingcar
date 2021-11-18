package step3;

import java.util.Objects;

public class CarName {

    public static final String VALID_MSG_CAR_NAME_EXCESS_SIZE = "자동차 이름은 5자를 초과할 수 없습니다.";
    public static final String VALID_MSG_CAR_NAME_UNDER_SIZE = "자동차 이름은 공백이 올 수 없습니다.";
    public static final int VALID_CAR_SIZE_VALUE = 5;

    public final String value;

    public CarName(String name) {
        boolean isEmptyName = name.length() == 0;
        boolean isCarNameOverLength = name.length() > VALID_CAR_SIZE_VALUE;

        name = name.trim();
        validCarName(isEmptyName, VALID_MSG_CAR_NAME_UNDER_SIZE);
        validCarName(isCarNameOverLength, VALID_MSG_CAR_NAME_EXCESS_SIZE);

        this.value = name;
    }

    private void validCarName(boolean expression, String expressionMessage) {
        if (expression) {
            throw new IllegalArgumentException(expressionMessage);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

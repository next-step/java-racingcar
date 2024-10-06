package race;

import java.util.Objects;

public class CarName {

    private static final int CAR_NAME_LENGTH = 5;
    private final String value;

    public CarName(String value) {
        if (value.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름이 너무 깁니다");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CarName))
            return false;
        CarName carName = (CarName)o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

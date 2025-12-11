package step5.racing.domain;

import java.util.Objects;

public class CarName {

    private static final String INVALID_CAR_NAME_MESSAGE= "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    private void validate(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    public String value() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName other = (CarName) o;
        return Objects.equals(carName, other.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}

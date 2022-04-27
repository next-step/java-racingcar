package domain;

import java.util.Objects;

public class CarName {
    private static final String WRONG_CAR_NAME_MESSAGE = "이름은 빈칸이거나 공백, 또는 Null일 수 없습니다.";
    private static final String WRONG_CAR_NAME_LENGTH_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isBlank() || carName.isEmpty()) {
            throw new IllegalArgumentException(WRONG_CAR_NAME_MESSAGE);
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(WRONG_CAR_NAME_LENGTH_MESSAGE);
        }
    }

    public String getName() {
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
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}

package racingCar.model;

import java.util.Objects;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
        }
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.carName = carName;
    }

    public String value() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}

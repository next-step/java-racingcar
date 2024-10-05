package racingcar.logic;

import java.util.Objects;

public class CarName {
    private static final String NEGATIVE_POSITION_MESSAGE = "음수 포지션은 존재할 수 없습니다.";
    public static final int MAX_CAR_NAME_LENGTH = 5;

    private final String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    public static CarName valueOf(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(NEGATIVE_POSITION_MESSAGE);
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(NEGATIVE_POSITION_MESSAGE);
        }
        return new CarName(carName);
    }

    public String getCarName() {
        return this.carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return carName.equals(carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carName);
    }
}

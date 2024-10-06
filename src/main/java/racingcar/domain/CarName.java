package racingcar.domain;

import java.util.Objects;

public class CarName {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String BLANK_CAR_NAME_MESSAGE = "차 이름은 빈 칸일 수 없습니다";
    public static final String TOO_LONG_CAR_NAME_MESSAGE = "차 이름이 너무 깁니다.";
    private final String value;

    private CarName(String carName) {
        this.value = carName;
    }

    public static CarName valueOf(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME_MESSAGE);
        }
        if (isTooLong(carName)) {
            throw new IllegalArgumentException(TOO_LONG_CAR_NAME_MESSAGE);
        }
        return new CarName(carName);
    }

    public static boolean isTooLong(String carName) {
        return carName.length() > MAX_CAR_NAME_LENGTH;
    }

    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return value.equals(carName1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

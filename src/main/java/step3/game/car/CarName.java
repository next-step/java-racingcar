package step3.game.car;

import java.util.Objects;

public class CarName {

    public static final String MAXIMUM_CAR_NAME_EXCEPTION_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다. 입력 값: ";
    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        if (carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new RuntimeException(MAXIMUM_CAR_NAME_EXCEPTION_MESSAGE + carName);
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName that = (CarName) o;
        return Objects.equals(this.carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.carName);
    }
}

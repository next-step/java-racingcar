package domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private String carName;

    public CarName(String carName) {
        if (!isValid(carName)) {
            throw new IllegalStateException("자동차 이름은 빈 값이거나 5자를 초과할 수 없습니다.");
        }
        this.carName = carName;
    }

    private boolean isValid(String carName) {
        return carName != null && !carName.isEmpty() && carName.length() < MAX_CAR_NAME_LENGTH;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CarName compareCarName = (CarName) obj;
        return Objects.equals(carName, compareCarName.carName);
    }
}

package racingcar;

import java.util.Objects;

public class CarName {
    private static final int MAX_NUMBER_OF_CAR_NAME = 5;
    private final String carName;

    public CarName(String name) {
        validateCarName(name);
        this.carName = name;
    }

    private void validateCarName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("자동차 이름은 null이 될 수 없습니다.");
        }

        if(name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 null이 될 수 없습니다.");
        }

        if (name.length() > MAX_NUMBER_OF_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    public String getName() {
        return carName;
    }
}

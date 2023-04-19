package racingcar.domain;

import java.util.Objects;

public class CarName {

    public static final int MAX_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        if(carName.length() > MAX_LENGTH) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
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

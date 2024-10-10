package racingcar.domain;

import java.util.Objects;

public class CarNo {
    private final int value;

    private CarNo(int carNo) {
        this.value = carNo;
    }

    public static CarNo valueOf(int carNo) {
        return new CarNo(carNo);
    }

    public int value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNo carNo1 = (CarNo) o;
        return value == carNo1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

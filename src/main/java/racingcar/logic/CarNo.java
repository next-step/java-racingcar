package racingcar.logic;

import java.util.Objects;

public class CarNo {
    private final int carNo;

    private CarNo(int carNo) {
        this.carNo = carNo;
    }

    public static CarNo valueOf(int carNo) {
        return new CarNo(carNo);
    }

    public int getCarNo() {
        return this.carNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNo carNo1 = (CarNo) o;
        return carNo == carNo1.carNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carNo);
    }
}

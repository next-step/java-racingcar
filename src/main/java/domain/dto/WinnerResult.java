package domain.dto;

import domain.Car;

import java.util.Objects;

public class WinnerResult {
    private final String carName;

    public WinnerResult(String carName) {
        this.carName = carName;
    }

    public static WinnerResult from(Car car) {
        return new WinnerResult(car.getName());
    }

    public String getCarName() {
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
        WinnerResult that = (WinnerResult) o;
        return Objects.equals(carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}

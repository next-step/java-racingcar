package racingcar.domain;

import java.util.Objects;

public class ResultCar {
    private String carName;
    private int location;

    public ResultCar(String carName, int location) {
        this.carName = carName;
        this.location = location;
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultCar resultCar = (ResultCar) o;
        return location == resultCar.location && Objects.equals(carName, resultCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, location);
    }
}

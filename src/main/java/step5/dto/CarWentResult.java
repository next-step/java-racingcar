package step5.dto;

import java.util.Objects;

public class CarWentResult {

    private final String carName;

    private final int distance;

    public CarWentResult(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarWentResult that = (CarWentResult) o;
        return carName == that.carName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

}

package step3.dto;

import java.util.Objects;

public class CarWentResult {

    private final int carNumber;

    private final int distance;

    public CarWentResult(int carNumber, int distance) {
        this.carNumber = carNumber;
        this.distance = distance;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarWentResult that = (CarWentResult) o;
        return carNumber == that.carNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }
}

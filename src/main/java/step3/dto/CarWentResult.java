package step3.dto;

import java.util.Objects;

public class CarWentResult {

    private final Integer carNumber;

    private final Integer distance;

    public CarWentResult(Integer carNumber, Integer distance) {
        this.carNumber = carNumber;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarWentResult that = (CarWentResult) o;
        return carNumber.equals(that.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public Integer getDistance() {
        return distance;
    }
}

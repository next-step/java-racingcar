package step3.dto;

import java.util.Objects;

public class CarWentResult {

    private final Integer distance;

    private final Integer carNumber;

    public CarWentResult(Integer distance, Integer carNumber) {
        this.distance = distance;
        this.carNumber = carNumber;
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

    public Integer getDistance() {
        return distance;
    }

    public Integer getCarNumber() {
        return carNumber;
    }
}

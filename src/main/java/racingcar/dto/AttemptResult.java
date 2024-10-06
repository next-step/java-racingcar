package racingcar.dto;

import racingcar.domain.Car;

import java.util.List;
import java.util.Objects;

public class AttemptResult {
    private final List<Car> cars;

    public AttemptResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttemptResult that = (AttemptResult) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
}

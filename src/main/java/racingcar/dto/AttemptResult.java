package racingcar.dto;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AttemptResult {
    private final List<Car> cars;

    public AttemptResult(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public String formatAttempt(String lineSeparator) {
        return cars.stream()
                .map(car -> car.print() + lineSeparator)
                .collect(Collectors.joining()) + lineSeparator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AttemptResult that = (AttemptResult) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }

    @Override
    public String toString() {
        return "AttemptResult{" +
                "cars=" + cars +
                '}';
    }
}

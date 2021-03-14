package racingcar.dto;

import racingcar.domain.Cars;

import java.util.Objects;

public class Round {
    private final Cars cars;

    public Round(Cars cars) {
        this.cars = cars;
    }

    public Cars getAllCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return Objects.equals(cars, round.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}

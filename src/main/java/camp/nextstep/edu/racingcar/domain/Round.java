package camp.nextstep.edu.racingcar.domain;

import java.util.Objects;

public class Round {
    private final Cars cars;

    private Round(Cars cars) {
        assert cars != null;
        this.cars = cars;
    }

    public static Round initialRoundFrom(int numberOfCars) {
        final Cars initialCars = Cars.defaultInstance(numberOfCars);
        return new Round(initialCars);
    }

    public Cars getCars() {
        return cars;
    }

    public Round move(MovingStrategy movingStrategy) {
        final Cars movedCars = cars.move(movingStrategy);
        return new Round(movedCars);
    }

    @Override
    public String toString() {
        return "Round{" +
                "cars=" + cars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return cars.equals(round.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}

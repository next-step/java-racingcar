package camp.nextstep.edu.racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Round {
    private final Cars cars;

    private Round(Cars cars) {
        assert cars != null;
        this.cars = cars;
    }

    public static Round initialRoundFrom(CarNames carNames) {
        final Cars initialCars = Cars.defaultInstance(carNames);
        return new Round(initialCars);
    }

    public Cars getCars() {
        return cars;
    }

    public Round move(MovingStrategy movingStrategy) {
        final Cars movedCars = cars.move(movingStrategy);
        return new Round(movedCars);
    }

    public CarNames getWinners() {
        final int maxPosition = this.getMaximumPosition();
        final List<String> carList = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        return CarNames.from(carList);
    }

    private Integer getMaximumPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(0, Integer::max);
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

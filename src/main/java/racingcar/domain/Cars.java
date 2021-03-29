package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> carList) {
        return new Cars(carList);
    }

    public void runRound(MoveStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public List<Car> getCarsAtRound() {
        return cars;
    }

    private Position maxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public Winners getWinners() {
        List<Name> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinners(winners, car);
        }
        return Winners.of(winners);
    }

    private void addWinners(List<Name> winners, Car car) {
        if (car.isWinner(maxPosition())) {
            winners.add(new Name(car.getName()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}

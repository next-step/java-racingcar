package racingcar;

import java.util.List;
import java.util.Objects;

public class Round {

    private final Cars cars;

    public Round(Cars carsFromPreviousRound) {
        cars = new Cars(carsFromPreviousRound);
    }

    public Cars moveCars(MoveStrategy moveStrategy) {
        return cars.move(moveStrategy);
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

    List<Car> getCarsStatusOfCurrentRound() {
        return cars.getCars();
    }
}

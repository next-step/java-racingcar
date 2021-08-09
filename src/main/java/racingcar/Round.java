package racingcar;

import java.util.List;
import java.util.Objects;

public class Round {

    private Cars cars;

    public Round(Cars carsFromPreviousRound) {
        cars = new Cars(carsFromPreviousRound);
    }

    public Cars moveCars(MoveStrategy moveStrategy) {
        cars = cars.move(moveStrategy);
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

    List<Integer> getCarsPositionOfCurrentRound() {
        return cars.getCarsPosition();
    }
}

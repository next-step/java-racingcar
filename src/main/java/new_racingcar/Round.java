package new_racingcar;

import java.util.List;

public class Round {
    private final Cars cars;

    public Round(Cars cars) {
        this.cars = cars;
    }

    public List<Car> getRoundInfo() {
        return cars.getUnmodifiableCars();
    }
}

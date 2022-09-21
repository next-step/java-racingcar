package racingcar.domain;

import java.util.List;

public class RaceGame {
    private Cars cars;

    public RaceGame(Cars cars) {
        this.cars = cars;
    }

    public void race() {
        cars = cars.move();
    }

    public int joinCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}

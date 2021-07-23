package racingcar.car;

import java.util.List;

public class RacingGame {

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void race() {
        cars.move();
    }

    public List<Car> getCars() {
        return cars.cars();
    }

}

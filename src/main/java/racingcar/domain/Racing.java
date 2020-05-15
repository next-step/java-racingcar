package racingcar.domain;

import racingcar.moving.MovingStrategy;

import java.util.List;

public class Racing {

    private Cars cars;

    public static Racing of(final Cars cars) {
        return new Racing(cars);
    }

    private Racing() {
    }

    private Racing(final Cars cars) {
        this.cars = cars;
    }

    public void run(final MovingStrategy movingStrategy) {
        cars.moveCars(movingStrategy);
    }

    public List<Car> getCars() {
        return this.cars.getCars();
    }

    public List<Car> getWinnerCars() {
        return this.cars.getWinnerCars();
    }
}

package racingcar.race;

import racingcar.car.Car;
import racingcar.car.Cars;

import java.util.List;

public class Race {
    private Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void startRace() {
        cars.moveCars();
    }

    public Cars getCars() {
        return this.cars;
    }

    public List<Car> getRaceWinners() {
        int maxPosition = cars.getCarsMaxPosition();
        return cars.getWinnerCars(maxPosition);
    }
}

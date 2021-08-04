package racingcar.race;

import racingcar.car.Cars;

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
}

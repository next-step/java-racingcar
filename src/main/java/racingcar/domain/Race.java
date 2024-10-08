package racingcar.domain;

import racingcar.utils.RandomMovement;

public class Race {
    private final Cars cars;
    public Race(Cars cars) {
        this.cars = cars;
    }

    public void run() {
        for (Car car : cars.getCars()) {
            Movement movement = new RandomMovement();
            car.move(movement.isMove());
        }
    }
}

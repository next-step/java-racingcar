package racingcar.domain.round;

import racingcar.domain.car.Cars;

public class Round {
    private final Cars cars;

    public Round(Cars cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(Cars cars) {
        if (cars == null) {
            throw new IllegalArgumentException("cars없이 Round는 생성될 수 없습니다.");
        }
    }

    public Round play() {
        return new Round(cars.act());
    }

    public Cars getCars() {
        return cars;
    }
}

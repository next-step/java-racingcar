package racingcar.domain;

import racingcar.util.ValidateUtils;

import java.util.List;

public class RacingCar {
    private final Cars cars;
    private final Count count;

    public RacingCar(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    public void start() {
        for (int i = 0; i < count.getCount(); i++) {
            cars.run();
        }
    }

    public Cars getCars() {
        return this.cars;
    }

}

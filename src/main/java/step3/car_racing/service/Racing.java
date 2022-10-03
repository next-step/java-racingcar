package step3.car_racing.service;

import step3.car_racing.model.Car;
import step3.car_racing.model.Cars;

import static step3.car_racing.util.RandomUtil.isForward;

public class Racing {

    private final Cars raceResult;

    public Racing(Cars cars) {
        for (Car car : cars.getCarList()) {
            car.move(isForward());
        }
        this.raceResult = cars;
    }

    public Cars getRaceResult() {
        return raceResult;
    }
}

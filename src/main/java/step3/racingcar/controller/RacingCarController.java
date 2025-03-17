package step3.racingcar.controller;

import step3.racingcar.model.RacingCar;

public class RacingCarController {

    private RacingCar car;

    public void ready(RacingCar car) {
        this.car = car;
    }

    public void run() {
        car.run();
    }

}

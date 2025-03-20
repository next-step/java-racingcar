package step4.racingcar2.controller;

import step4.racingcar2.model.RacingCar;

public class RacingCarController {

    private RacingCar car;

    public void ready(RacingCar car) {
        this.car = car;
    }

    public void run() {
        car.run();
    }

}

package racingcar.controller;

import racingcar.service.cars.CarsService;

import java.util.List;

public class RacingCarGame {

    private final CarsService carsService;
    public RacingCarGame(CarsService carsService) {
        this.carsService = carsService;
    }
    public void run() {

        List<String> carsName = carsService.getCarsName();
    }
}

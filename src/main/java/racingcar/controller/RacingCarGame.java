package racingcar.controller;

import racingcar.service.CarsService;
import racingcar.view.InputView;

public class RacingCarGame {

    private final CarsService carsService;
    public RacingCarGame(CarsService carsService) {
        this.carsService = carsService;
    }
    public void run() {

        carsService.getCarsName();
    }
}

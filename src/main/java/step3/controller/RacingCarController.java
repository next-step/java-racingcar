package step3.controller;

import step3.model.Cars;
import step3.model.MoveStrategy;
import step3.model.RaceWinners;
import step3.view.InputView;
import step3.view.OutputView;

public class RacingCarController {

    public RacingCarController() {
    }

    public void racing() {
        Cars cars = Cars.from(InputView.getCarNames());
        int tryCount = InputView.getTryCount();
        OutputView.printRacingResult();

        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(new MoveStrategy());
            OutputView.printRacingProgress(cars);
        }

        RaceWinners raceWinners = cars.getRaceWinners();
        OutputView.printRacingWinners(raceWinners.getWinnerNames());
    }
}

package racing.controller;

import racing.model.Cars;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingCarApplication {
    InputView inputView;
    OutputView outputView;

    public RacingCarApplication(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() throws IllegalAccessException {
        Cars cars = Cars.of(inputView.getCarName());
        int raceCount = inputView.getRaceRound();
        for (int round = 0; round < raceCount; round++) {
            cars.raceAllCars();
            outputView.showRaceProgress(cars.cars());
        }
        outputView.showWinners(cars.getWinnerNames());
    }

}

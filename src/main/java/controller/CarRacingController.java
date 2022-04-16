package controller;

import domain.Positions;
import service.CarRacingService;
import view.InputView;
import view.ResultView;

import java.util.List;

public class CarRacingController {
    private final InputView inputView;
    private final ResultView resultView;
    private final CarRacingService carRacingService;

    public CarRacingController(InputView inputView, ResultView resultView, CarRacingService carRacingService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.carRacingService = carRacingService;
    }

    public void startRacingGame() {
        int carCount = inputView.inputCarCount();
        int attemptCount = inputView.inputAttemptCount();
        carRacingService.registerNewCars(carCount);
        List<Positions> racingResult = carRacingService.startRacing(attemptCount);
        resultView.printResult(racingResult);
    }
}

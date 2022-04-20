package controller;

import domain.CarRacingResultDto;
import service.CarRacingService;
import view.InputView;
import view.ResultView;

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
        String carsName = inputView.inputCarsName();
        String attemptCount = inputView.inputAttemptCount();

        CarRacingResultDto result = carRacingService.registerCarsAndStartRacing(carsName, attemptCount);
        resultView.printRacingResult(result);
    }
}

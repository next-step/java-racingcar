package racing.controller;

import racing.application.service.RacingService;
import racing.application.view.InputView;
import racing.application.view.OutputView;
import racing.dto.CarRaceDto;

public class RacingController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RacingService racingService = new RacingService();

    public CarRaceDto makeCars() {
        return racingService.makeCars(inputView.numberOfCars());
    }

    public void racingGame(CarRaceDto carRaceDto) {
        int moveCount = inputView.moveCount();

        for (int i = 0; i < moveCount; i++) {
            carRaceDto = racingService.racingGame(carRaceDto);
            outputView.result(carRaceDto);
        }
    }

}

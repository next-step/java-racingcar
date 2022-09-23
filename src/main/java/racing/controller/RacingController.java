package racing.controller;

import racing.dto.CarRaceDto;
import racing.service.RacingService;
import racing.view.InputView;
import racing.view.OutputView;

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

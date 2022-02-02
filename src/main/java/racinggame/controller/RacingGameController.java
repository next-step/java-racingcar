package racinggame.controller;

import racinggame.domain.car.Cars;
import racinggame.service.RacingGameService;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameController {

    private final InputView inputView;
    private final ResultView resultView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, ResultView resultView,
        RacingGameService racingGameService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.racingGameService = racingGameService;
    }

    public void run() {
        final Cars cars = new Cars(inputView.inputPlayerName());
        final int tryNumber = inputView.inputTryNumber();
        resultView.printResult(racingGameService.race(cars, tryNumber));
    }

}

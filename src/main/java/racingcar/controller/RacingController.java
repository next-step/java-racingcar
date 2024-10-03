package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {

    private InputView inputView;
    private ResultView resultView;

    public RacingController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        int carNumber = inputView.getCarNumber();
        int matchNumber = inputView.getMatchNumber();
        RacingService racingService = new RacingService(carNumber, matchNumber);

        while (racingService.isMatching()) {
            racingService.match();
            resultView.printRacingCarsStatus(racingService.getRacingCarsStatus());
        }
    }
}

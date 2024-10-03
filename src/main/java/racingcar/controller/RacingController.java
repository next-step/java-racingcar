package racingcar.controller;

import racingcar.service.RacingGame;

public class RacingController {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        int carNumber = inputView.getCarNumber();
        int matchNumber = inputView.getMatchNumber();
        RacingGame racingGame = new RacingGame(carNumber, matchNumber);

        while (racingGame.isMatching()) {
            racingGame.match();
            resultView.printRacingCarsStatus(racingGame.getRacingCarsStatus());
        }
    }
}

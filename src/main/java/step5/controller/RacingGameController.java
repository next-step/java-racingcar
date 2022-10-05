package step5.controller;

import java.util.List;
import step5.domain.RacingResult;
import step5.domain.RacingGame;
import step5.service.RacingWinnerService;
import step5.view.InputView;
import step5.view.ResultView;

public class RacingGameController {

    private final RacingGame racingGame;

    public RacingGameController() {
        ResultView.printCarNames();
        String[] carNames = InputView.carNames();
        ResultView.printTryCount();
        int tryCount = InputView.tryCount();
        this.racingGame = new RacingGame(carNames, tryCount);
    }

    public void start() {
        ResultView.printStartMessage();

        List<RacingResult> racingResults = racingGame.start();
        int carCount = racingGame.getCarCount();
        String winner = RacingWinnerService.chooseWinner(racingResults);

        ResultView.printRacingResults(racingResults, carCount);
        ResultView.printWinner(winner);
    }
}

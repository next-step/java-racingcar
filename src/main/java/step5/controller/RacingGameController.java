package step5.controller;

import java.util.List;
import step5.domain.MovingStrategy;
import step5.domain.RacingGame;
import step5.domain.RacingResult;
import step5.service.RacingWinnerService;
import step5.view.InputView;
import step5.view.ResultView;

public class RacingGameController {
    public String[] inputCarNames() {
        ResultView.printCarNames();
        return InputView.carNames();
    }

    public int inputTryCount() {
        ResultView.printTryCount();
        return InputView.tryCount();
    }

    public void play(final RacingGame racingGame) {
        ResultView.printStartMessage();

        final List<RacingResult> racingResults = racingGame.start();
        final int carCount = racingGame.getCarCount();
        final String winner = RacingWinnerService.chooseWinner(racingResults);

        ResultView.printRacingResults(racingResults, carCount);
        ResultView.printWinner(winner);
    }

    public RacingGame makeRacingGame(final String[] carNames, final int tryCount,
        final MovingStrategy movingStrategy) {
        return new RacingGame(carNames, tryCount, movingStrategy);
    }
}

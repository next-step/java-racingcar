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

    public void play(RacingGame racingGame) {
        ResultView.printStartMessage();

        List<RacingResult> racingResults = racingGame.start();
        int carCount = racingGame.getCarCount();
        String winner = RacingWinnerService.chooseWinner(racingResults);

        ResultView.printRacingResults(racingResults, carCount);
        ResultView.printWinner(winner);
    }

    public RacingGame makeRacingGame(String[] carNames, int tryCount,
        MovingStrategy movingStrategy) {
        return new RacingGame(carNames, tryCount, movingStrategy);
    }
}

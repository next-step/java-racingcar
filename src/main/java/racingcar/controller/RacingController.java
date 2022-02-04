package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {

    private static final int START_FROM_ZERO = 0;

    private final RacingGame racingGame;
    private final InputView inputView;
    private final ResultView resultView;

    public RacingController(final RacingGame racingGame, final InputView inputView,
        final ResultView resultView) {
        this.racingGame = racingGame;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        setUpRacing();
        startRacing();
        finishRacing();
    }

    private void setUpRacing() {
        inputView.processConsoleInput();
        racingGame.registerCars(inputView.getSplitUserInput());
    }

    private void startRacing() {
        for (int time = START_FROM_ZERO; time < inputView.getRacingTime(); time++) {
            racingGame.drive();
        }
        resultView.announceRacingDetails(racingGame.getMovingResult());
    }

    private void finishRacing() {
        System.out.println(resultView.announceWinner(racingGame.judgeWinners()));
    }

}

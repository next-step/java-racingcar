package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.movable.RandomForwardStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {


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
        racingGame.registerCars(inputView.getSplitUserInput(), new RandomForwardStrategy());
    }

    private void startRacing() {
        racingGame.drive(inputView.getRacingTime(), resultView);
        resultView.announceRacingDetails(racingGame.getMovingResult());
    }

    private void finishRacing() {
        resultView.announceWinner(racingGame.judgeWinners());
    }

}

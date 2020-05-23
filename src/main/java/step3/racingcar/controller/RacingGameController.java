package step3.racingcar.controller;

import step3.racingcar.domain.Message;
import step3.racingcar.domain.RacingGame;
import step3.racingcar.view.InputView;
import step3.racingcar.view.ResultView;

public class RacingGameController {

    private RacingGame racingGame;
    private final InputView inputView;
    private final ResultView resultView;

    public RacingGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void processUserInputs() {
        String[] carNames = inputView.getCarNames(Message.CAR_NAMES);
        int gameTryCounts = inputView.getGameTryCounts(Message.GAME_TRY_COUNTS);
        this.racingGame = new RacingGame(carNames, gameTryCounts);
    }

    public void startGame() {
        if (racingGame == null) {
            throw new IllegalStateException(Message.ERROR_INVALID_ORDER);
        }
        resultView.printResultHeader(Message.RESULT_HEADER);
        while (racingGame.hasNextRound() == true) {
            racingGame.run();
            resultView.printResult(racingGame);
        }
        resultView.printWinnerCarNames(racingGame);
    }
}

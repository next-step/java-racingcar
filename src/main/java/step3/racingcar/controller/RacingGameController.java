package step3.racingcar.controller;

import step3.racingcar.domain.CarGroups;
import step3.racingcar.domain.Message;
import step3.racingcar.domain.RacingGame;
import step3.racingcar.view.InputView;
import step3.racingcar.view.ResultView;

public class RacingGameController {

    private RacingGame racingGame;
    private InputView inputView;
    private ResultView resultView;

    public RacingGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void processUserInput() {
        String[] carNames = inputView.getCarNames(Message.CAR_NAMES);
        int gameTryCounts = inputView.getGameTryCounts(Message.GAME_TRY_COUNTS);
        this.racingGame = new RacingGame(carNames, gameTryCounts);
    }

    public void startGame() {
        resultView.printResultHeader(Message.RESULT_HEADER);
        CarGroups playerCars = null;
        while (racingGame.hasNextRound() == true) {
            playerCars = racingGame.run();
            resultView.printResult(playerCars);
        }
        this.resultView.printWinnerCarNames(playerCars);
    }
}

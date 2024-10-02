package racingGame.controller;

import racingGame.domain.GameResult;
import racingGame.domain.RacingGame;
import racingGame.domain.RandomMovementCondition;
import racingGame.ui.RacingCarInputView;
import racingGame.ui.RacingCarOutputView;

public class RacingGameController {
    private final RacingCarInputView inputView;
    private final RacingCarOutputView outputView;

    public RacingGameController() {
        this.inputView = new RacingCarInputView();
        this.outputView = new RacingCarOutputView();
    }

    public void run() {
        String[] carNames = inputView.getCarNames();
        int attempts = inputView.getAttempts();

        RacingGame racingGame = new RacingGame(carNames, attempts, new RandomMovementCondition());
        GameResult gameResult = racingGame.run();

        outputView.printGame(gameResult);
    }
}
package racingGame.controller;

import racingGame.domain.RacingGame;
import racingGame.domain.RandomMovementCondition;
import racingGame.ui.RacingCarInputView;
import racingGame.ui.RacingCarOutputView;

import java.util.List;
import java.util.Map;

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
        List<Map<String, Integer>> allStates = racingGame.run();

        outputView.printGame(allStates, racingGame.getWinners());
    }
}
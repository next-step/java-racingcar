package racing.controller;

import racing.domain.GameSet;
import racing.domain.RacingGame;
import racing.rule.Rule;
import racing.view.GameInput;
import racing.view.GameResult;

public class RacingCarController {
    private final GameSet gameSet;
    private final GameResult gameResult = new GameResult();

    public RacingCarController(Rule rule) {
        this.gameSet = new GameSet(rule);
    }

    public void racingCarGame() {
        GameInput gameInput = new GameInput();
        gameSet.setNumberOfCars(gameInput.inputCarCount());
        gameSet.setNumberOfMove(gameInput.inputTryCount());

        RacingGame racingGame = new RacingGame(gameSet);
        racingGame.start();

        gameResult.print(racingGame.result());
    }
}

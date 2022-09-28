package racing.controller;

import racing.domain.GameSet;
import racing.domain.Game;
import racing.rule.move.RandomMove;
import racing.view.GameInput;
import racing.view.GameResult;

public class RacingCarController {

    public void racingCarGame() {
        GameInput gameInput = new GameInput();
        Game game = new Game(new GameSet.GameSetBuilder(
                gameInput.inputCarCount(), gameInput.inputMoveCount(), new RandomMove()).build());

        game.start();
        new GameResult(game).result();
    }
}
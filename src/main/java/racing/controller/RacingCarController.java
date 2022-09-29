package racing.controller;

import racing.domain.GameSet;
import racing.domain.Game;
import racing.rule.move.RandomMove;
import racing.view.GameInputView;
import racing.view.GameResultView;

public class RacingCarController {

    public void racingCarGame() {
        GameInputView gameInputView = new GameInputView();
        Game game = new Game(new GameSet.GameSetBuilder(
                new RandomMove(), gameInputView.inputCarNames(), gameInputView.inputMoveCount()).build());

        game.start();
        new GameResultView().result(game);
    }
}
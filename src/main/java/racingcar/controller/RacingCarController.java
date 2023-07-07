package racingcar.controller;

import racingcar.domain.Game;
import racingcar.view.OutputView;

public class RacingCarController {

    private final Game game;

    public RacingCarController(Game game) {
        this.game = game;
    }

    public void printResult() {
        OutputView.printResult(game.run(), game.findWinnerNames());
    }
}

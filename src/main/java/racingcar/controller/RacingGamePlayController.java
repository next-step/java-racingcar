package racingcar.controller;

import racingcar.controller.extension.input.Inputable;
import racingcar.controller.extension.view.Viewable;
import racingcar.domain.RacingGame;
import racingcar.domain.extension.Moveable;
import racingcar.domain.response.RacingGamePlayResponse;

public class RacingGamePlayController {

    private final Moveable moveable;
    private final Inputable inputable;
    private final Viewable viewable;

    public RacingGamePlayController(Inputable inputable, Viewable viewable, Moveable moveable) {
        this.inputable = inputable;
        this.viewable = viewable;
        this.moveable = moveable;
    }

    public void playRacingGame() {
        RacingGame racingGame = new RacingGame(inputable.inputRound(), inputable.inputCarNames(), moveable);

        RacingGamePlayResponse racingGamePlayResponse = racingGame.playAndGetRoundResults();

        viewable.draw(racingGamePlayResponse);
    }

}

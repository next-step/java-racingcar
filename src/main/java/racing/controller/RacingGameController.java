package racing.controller;

import racing.domain.RacingGame;
import racing.view.ResultView;


public class RacingGameController {
    private final RacingGame racingGame;

    public RacingGameController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void repeatRace() {
        while (racingGame.isProgress()) {
            racingGame.race();
            ResultView.printProgressView(racingGame);
        }
    }
}

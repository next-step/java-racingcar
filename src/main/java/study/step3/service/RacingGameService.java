package study.step3.service;

import study.step3.GameConfig;
import study.step3.RacingGame;

public class RacingGameService {
    private GameConfig gameConfig;
    private RacingGame racingGame;

    public RacingGameService(GameConfig gameConfig, RacingGame racingGame) {
        this.gameConfig = gameConfig;
        this.racingGame = racingGame;
    }

    public void play() {
        for (int i = 0; i < gameConfig.getGameCount(); i++) {
            racingGame.play();
        }
    }
}

package game;

import game.controller.RacingGame;
import game.domain.movable.RandomNumberMovableStrategy;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.play(new RandomNumberMovableStrategy());
    }
}

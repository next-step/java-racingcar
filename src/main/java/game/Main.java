package game;

import game.domain.RacingGame;
import game.domain.RacingGameRule;

public class Main {

    public static void main(String[] args) {
        RacingGame.start(new RacingGameRule(4));
    }
}

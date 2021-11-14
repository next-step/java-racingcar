package study.racing;

import study.racing.model.RacingGame;
import study.racing.model.rule.RandcomNumberRule;

public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new RandcomNumberRule());
        racingGame.start();
    }
}

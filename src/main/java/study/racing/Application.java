package study.racing;

import study.racing.controller.RacingGame;

public class Application {


    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.getInstance();
        racingGame.play();
    }
}

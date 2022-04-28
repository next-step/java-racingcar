package racingcar;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new Random());
        racingGame.play(racingGame.getCars());
    }
}

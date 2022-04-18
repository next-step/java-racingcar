package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.pattern.RandomValueGenerator;

public class RacingCarGameApp {
    public static void main(String[] args) {
        new RacingCarGame(RandomValueGenerator.getInstance()).gameStart();
    }
}

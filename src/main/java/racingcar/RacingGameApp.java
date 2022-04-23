package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.pattern.RandomValueGenerator;

public class RacingGameApp {
    public static void main(String[] args) {
        new RacingGameController(RandomValueGenerator.getInstance()).gameStart();
    }
}

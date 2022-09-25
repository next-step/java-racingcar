package racing;

import racing.controller.RacingCarController;
import racing.rule.RandomRule;

public class RacingCarApplication {

    public static void main(String[] args) {
        new RacingCarController(new RandomRule()).racingCarGame();
    }
}

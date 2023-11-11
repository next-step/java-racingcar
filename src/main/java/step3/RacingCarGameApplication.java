package step3;

import step3.controller.RacingCarController;
import step3.strategy.RandomNumMovingStrategy;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        RacingCarController racing = new RacingCarController(new RandomNumMovingStrategy());
        racing.startGame();
    }
}

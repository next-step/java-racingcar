package step3;

import step3.common.RandomNumberGenerator;
import step3.controller.RacingGameController;
import step3.model.MovableStrategy;

public class Main {
    public static void main(String[] args) {
        MovableStrategy movableStrategy = new MovableStrategy(new RandomNumberGenerator());
        RacingGameController racingGameController = new RacingGameController(movableStrategy);
        racingGameController.play();
    }
}

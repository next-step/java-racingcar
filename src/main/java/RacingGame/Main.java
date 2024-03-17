package RacingGame;

import RacingGame.common.RandomNumberGenerator;
import RacingGame.controller.RacingGameController;
import RacingGame.model.MovableStrategy;

public class Main {
    public static void main(String[] args) {
        MovableStrategy movableStrategy = new MovableStrategy(new RandomNumberGenerator());
        RacingGameController racingGameController = new RacingGameController(movableStrategy);
        racingGameController.play();
    }
}

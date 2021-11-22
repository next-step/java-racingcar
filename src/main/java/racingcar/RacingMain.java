package racingcar;

import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomMovingStrategy;

public class RacingMain {
    public static void main(String[] args) {
        MovingStrategy strategy = new RandomMovingStrategy();
        Game game = new Game(strategy);
        game.racingCars();
    }
}

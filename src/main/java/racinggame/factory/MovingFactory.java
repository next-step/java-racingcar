package racinggame.factory;

import racinggame.strategy.MovingStrategy;
import racinggame.strategy.RandomMovingStrategy;
import racinggame.util.RandomNumber;

public class MovingFactory {

    private MovingFactory() {
    }

    public static MovingStrategy movingStrategy() {
        return new RandomMovingStrategy(new RandomNumber());
    }
}

package racing.domain;

import racing.util.RandomNumber;

public class MovingStrategyFactory {
    private MovingStrategyFactory() {
    }

    public static MovingStrategy getStrategy() {
        return new RandomMovingStrategy(new RandomNumber());
    }
}

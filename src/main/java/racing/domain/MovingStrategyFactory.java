package racing.domain;

import racing.util.RandomNumber;

public class MovingStrategyFactory {
    private MovingStrategyFactory() {
    }

    public static MovingStrategy getRandomStrategy() {
        return new RandomMovingStrategy(new RandomNumber());
    }
}

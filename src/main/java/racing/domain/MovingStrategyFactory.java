package racing.domain;

import racing.utils.RandomNumber;

public class MovingStrategyFactory {
    private MovingStrategyFactory() {
    }

    public static MovingStrategy getRandomStrategy() {
        return new RandomMovingStrategy(new RandomNumber());
    }
}

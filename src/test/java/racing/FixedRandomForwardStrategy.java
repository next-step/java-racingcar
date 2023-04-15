package racing;

import racing.domain.move.MoveStrategy;


public class FixedRandomForwardStrategy implements MoveStrategy {
    //    private static final int MAX_RANDOM_VALUE = 9;
    private static final int THRESHOLD_ONGOING = 4;
    private final int randomValue;

    public FixedRandomForwardStrategy(int randomValue) {
        this.randomValue = randomValue;
    }

    public boolean move() {
        return random();
    }

    private boolean random() {
        return randomValue >= THRESHOLD_ONGOING;
    }
}
package racewinner.domain.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final static int MAX_NUMBER = 10;
    @Override
    public int number() {
        return new Random().nextInt(MAX_NUMBER);
    }
}

package step3.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 10;

    @Override
    public int generateNumber() {
        return RANDOM.nextInt(MAX_NUMBER);
    }
}

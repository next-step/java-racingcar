package step3;

import java.util.Random;

public class RandomStrategy implements MoveStrategy {

    private static final Random random = new Random();
    private static final Integer bound = 9;

    @Override
    public boolean move() {
        return strategy(random.nextInt(bound));
    }

    public boolean strategy(int value) {
        if (value > bound || value < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANDOM_VALUE);
        }
        return value > 4;
    }

}

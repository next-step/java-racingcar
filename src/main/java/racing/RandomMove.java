package racing;

import java.util.Random;

public class RandomMove implements MoveStrategy {

    private static final int BOUNDARY = 4;
    private static final int RANDOM_NUMBER = 10;

    private final Random random;

    public RandomMove() {
        this.random = new Random();
    }

    public RandomMove(Random random) {
        this.random = random;
    }

    @Override
    public Boolean isMove() {
        if (BOUNDARY <= random.nextInt(RANDOM_NUMBER)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}

package racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements IMoveStrategy {

    public static final int MAX_RAND_VALUE = 9;
    public static final int MIN_MOVE_VALUE = 4;

    private static final Random rand = new Random();

    @Override
    public boolean canMove() {
        return rand.nextInt(MAX_RAND_VALUE) >= MIN_MOVE_VALUE;
    }
}

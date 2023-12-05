package racingcar.model.movestrategy;

import java.util.Random;

public class RandomVarMoveStrategy implements MoveStrategy {
    private static final Random rand = new Random();
    private static final int RANDOM_VALUE_BOUND = 10;

    @Override
    public boolean canMove() {
        return new VarMoveStrategy(createRandomValue()).canMove();
    }

    private static int createRandomValue() {
        return rand.nextInt(RANDOM_VALUE_BOUND);
    }
}

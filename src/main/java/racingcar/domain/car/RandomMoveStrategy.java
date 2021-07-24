package racingcar.domain.car;

import utils.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy{

    public static final int BOUND = 10;
    public static final int MOVE = 4;

    @Override
    public boolean canMove() {
        return RandomUtils.nextInt(BOUND) >= MOVE;
    }
}

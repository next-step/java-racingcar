package step3.move;

import step3.util.RandomNumberUtils;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_BOUND = 4;

    private static final int successDistance = 1;

    private static final int failDistance = 0;


    @Override
    public int moveAmount() {
        if (isMove()) {
            return successDistance;
        }

        return failDistance;
    }

    private boolean isMove() {
        return RandomNumberUtils.generate() >= MOVE_BOUND;
    }
}

package carracing.move_strategy;

import static carracing.utils.RandomUtils.getPoint;

public class RandomMoveStopStrategy implements MoveStrategy {
    private static final int MINIMUM_MOVABLE_DISTANCE = 4;

    @Override
    public int getMovePoint() {
        int point = getPoint();
        if (movable(point)) {
            return point;
        }
        return 0;
    }

    private boolean movable(int i) {
        return i >= MINIMUM_MOVABLE_DISTANCE;
    }
}

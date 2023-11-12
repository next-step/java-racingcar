package carracing.domain.race.move;

import carracing.domain.race.point.PointProvider;


public class RandomMoveStopStrategy implements MoveStrategy {
    private static final int MINIMUM_MOVABLE_DISTANCE = 4;
    private static final int STOP_DISTANCE = 0;
    private final PointProvider pointProvider;

    public RandomMoveStopStrategy(PointProvider pointProvider) {
        this.pointProvider = pointProvider;
    }

    @Override
    public int getMovePoint() {
        int point = pointProvider.getPoint();
        if (movable(point)) {
            return point;
        }
        return STOP_DISTANCE;
    }

    private boolean movable(int i) {
        return i >= MINIMUM_MOVABLE_DISTANCE;
    }
}

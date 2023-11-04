package car_racing.move_strategy;

import static car_racing.move_strategy.RandomPoint.getPoint;

public class RandomMoveStopStrategy implements MoveStrategy {
    @Override
    public int getMovePoint() {
        int point = getPoint();
        if (movable(point)) {
            return point;
        }
        return 0;
    }

    private boolean movable(int i) {
        return i >= 4;
    }
}

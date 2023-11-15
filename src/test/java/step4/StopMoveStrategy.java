package step4;

import step4.model.MoveStrategy;

public class StopMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        return false;
    }
}

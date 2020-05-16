package step3.domain;

public class StopMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        return false;
    }
}

package racing.domain;

public class SuspendMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMovable() {
        return false;
    }
}

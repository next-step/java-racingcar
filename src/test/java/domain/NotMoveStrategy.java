package domain;

public class NotMoveStrategy implements MoveStrategy {
    @Override
    public boolean isCanMove() {
        return false;
    }
}

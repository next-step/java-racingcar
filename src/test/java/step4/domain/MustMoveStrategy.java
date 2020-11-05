package step4.domain;


public class MustMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMoved(int number) {
        return true;
    }

    @Override
    public boolean isMoved() {
        return true;
    }
}

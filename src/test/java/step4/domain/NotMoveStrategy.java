package step4.domain;


public class NotMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMoved(int number) {
        return true;
    }

    @Override
    public boolean isMoved() {
        return false;
    }
}

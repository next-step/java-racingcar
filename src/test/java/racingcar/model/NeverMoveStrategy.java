package racingcar.model;

public class NeverMoveStrategy implements MoveStrategy{

    @Override
    public boolean canMove() {
        return false;
    }
}

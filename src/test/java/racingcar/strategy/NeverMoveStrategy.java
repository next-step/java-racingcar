package racingcar.strategy;

public class NeverMoveStrategy implements IMoveStrategy {

    @Override
    public boolean canMove() {
        return false;
    }
}
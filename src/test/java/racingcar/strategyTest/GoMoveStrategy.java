package racingcar.strategyTest;

public class GoMoveStrategy implements MoveStrategy {

    @Override
    public boolean decideMoveOrHold() {
        return true;
    }
}

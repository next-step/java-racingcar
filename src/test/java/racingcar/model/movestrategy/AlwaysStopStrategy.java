package racingcar.model.movestrategy;

public class AlwaysStopStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return false;
    }
}

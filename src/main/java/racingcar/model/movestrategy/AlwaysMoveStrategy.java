package racingcar.model.movestrategy;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove(int value) {
        return true;
    }
}

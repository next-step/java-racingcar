package racingcar.model.movestrategy;

public class VarMoveStrategy implements MoveStrategy {
    private static final int THRESHOLD_NUMBER = 4;
    private final int value;

    public VarMoveStrategy(int value) {
        this.value = value;
    }

    @Override
    public boolean canMove() {
        return value >= THRESHOLD_NUMBER;
    }
}

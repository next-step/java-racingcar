package racingcar.model.movestrategy;

public class VarMoveStrategy implements MoveStrategy {
    private final int value;

    private static final int THRESHOLD_NUMBER = 4;

    public VarMoveStrategy(int value) {
        this.value = value;
    }

    @Override
    public boolean canMove() {
        return value >= THRESHOLD_NUMBER;
    }
}

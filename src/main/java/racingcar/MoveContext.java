package racingcar;

public class MoveContext {
    public final MoveStrategy moveStrategy;

    public MoveContext(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    private boolean isMovable(Integer number) {
        return moveStrategy.isMovable(number);
    }
}

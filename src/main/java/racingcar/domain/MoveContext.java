package racingcar.domain;

public class MoveContext {
    public final MoveStrategy moveStrategy;

    public MoveContext(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}

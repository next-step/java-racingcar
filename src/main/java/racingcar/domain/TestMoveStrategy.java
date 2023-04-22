package racingcar.domain;

public class TestMoveStrategy implements MoveStrategy {

    private final boolean moved;

    public TestMoveStrategy(boolean moved) {
        this.moved = moved;
    }

    @Override
    public boolean isMove() {
        return moved;
    }
}

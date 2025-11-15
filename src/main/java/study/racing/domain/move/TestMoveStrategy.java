package study.racing.domain.move;

public class TestMoveStrategy implements MoveStrategy{

    private final boolean isMove;

    public TestMoveStrategy(boolean isMove) {
        this.isMove = isMove;
    }

    @Override
    public boolean isMove() {
        return this.isMove;
    }
}

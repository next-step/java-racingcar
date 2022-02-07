package racingcar.domain;

public class FixedMove implements MoveStrategy {

    private final int fixedMove;

    public FixedMove(int fixedMove) {
        this.fixedMove = fixedMove;
    }

    @Override
    public int movable() {
        return fixedMove;
    }
}

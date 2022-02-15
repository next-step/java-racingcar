package racing.domain;

public class RandomMoveRule implements MoveRule {

    private static final int MOVE_CONDITION = 4;

    @Override
    public int makeValue() {
        return (int) (Math.random() * 10);
    }

    @Override
    public boolean isMovable() {
        return makeValue() >= MOVE_CONDITION;
    }
}

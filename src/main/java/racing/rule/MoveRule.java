package racing.rule;

public abstract class MoveRule {
    public static final int MIN_MOVE_VALUE = 4; // 전진하기 위한 최소값

    public abstract boolean isMovable(int value);
}

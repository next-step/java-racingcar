package study.racing.domain;

public class DefaultMovingCondition implements MovingCondition {
    public static final int DEFAULT_NUMBER_TO_MOVE = 0;

    @Override
    public boolean movable(int number) {
        return number >= DEFAULT_NUMBER_TO_MOVE;
    }
}

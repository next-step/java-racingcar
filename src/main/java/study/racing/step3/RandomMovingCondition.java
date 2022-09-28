package study.racing.step3;

public class RandomMovingCondition implements MovingCondition {
    public static final int MINIMUM_NUMBER_TO_MOVE = 4;

    @Override
    public boolean movable(int number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }
}

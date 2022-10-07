package step5.domain;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MINIMUM_MOVABLE_VALUE = 4;

    @Override
    public boolean isMovable(int value) {
        return value >= MINIMUM_MOVABLE_VALUE;
    }

}

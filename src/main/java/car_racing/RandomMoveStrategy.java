package car_racing;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVE_THRESH_HOLD = 4;
    private static final int RANDOM_RANGE_FROM_INCLUDE = 0;
    private static final int RANDOM_RANGE_TO_EXCLUDE = 10;

    public RandomMoveStrategy() {
    }

    @Override
    public boolean decideToMove() {
        return getRandomNumber() >= MOVE_THRESH_HOLD;
    }

    private int getRandomNumber() {
        return RandomUtil.getRandomNumber(RANDOM_RANGE_FROM_INCLUDE, RANDOM_RANGE_TO_EXCLUDE);
    }
}

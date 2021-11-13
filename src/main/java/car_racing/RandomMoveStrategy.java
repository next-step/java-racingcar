package car_racing;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVE_THRESH_HOLD = 4;

    private final int randomRangeFrom;
    private final int randomRangeTo;

    public RandomMoveStrategy() {
        this.randomRangeFrom = 0;
        this.randomRangeTo = 10;
    }

    /**
     * Test
     **/
    public RandomMoveStrategy(int randomRangeFrom, int randomRangeTo) {
        this.randomRangeFrom = randomRangeFrom;
        this.randomRangeTo = randomRangeTo;
    }

    @Override
    public boolean decideToMove() {
        return getRandomNumber() > MOVE_THRESH_HOLD;
    }

    private int getRandomNumber() {
        return RandomUtil.getRandomNumber(randomRangeFrom, randomRangeTo);
    }
}

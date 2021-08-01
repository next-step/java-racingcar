package racing.model;

import racing.util.RandomUtil;

public class RandomMovingStrategy implements MovingStrategy{
    private static final int MINIMUM_CONDITION = 4;
    private static final int MAXIMUM_CONDITION = 9;

    @Override
    public boolean movable() {
        return moveCondition(RandomUtil.randomValue());
    }

    public static Boolean moveCondition(int randomValue) {
        if(randomValue > MAXIMUM_CONDITION) {
            throw new IllegalStateException();
        }
        if(randomValue >= MINIMUM_CONDITION && randomValue <= MAXIMUM_CONDITION) {
            return true;
        }
        return false;
    }

}

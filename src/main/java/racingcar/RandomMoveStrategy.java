package racingcar;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static Random random;

    public RandomMoveStrategy() {
        if (this.random == null) {
            this.random = new Random();
        }
    }

    @Override
    public boolean checkMovable() {
        int bound = NumConst.RANDOM_MAX;
        int biggerThan = NumConst.RANDOM_BIGGER_THAN;
        int randomNum = this.random.nextInt(bound);
        return randomNum >= biggerThan;
    }
}

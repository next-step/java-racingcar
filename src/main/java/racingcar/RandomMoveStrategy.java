package racingcar;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static Random random;

    private RandomMoveStrategy() {
        if (this.random != null) {
            return;
        }
        this.random = new Random();
    }

    public static RandomMoveStrategy getInstance() {
        return RandomMoveStrategy.SingletonHelper.instance;
    }

    @Override
    public boolean checkMovable() {
        int bound = RandomMoveStrategyConst.RANDOM_MAX;
        int biggerThan = RandomMoveStrategyConst.RANDOM_BIGGER_THAN;
        int randomNum = this.random.nextInt(bound);
        return randomNum >= biggerThan;
    }

    private static class SingletonHelper {
        private static final RandomMoveStrategy instance = new RandomMoveStrategy();
    }
}

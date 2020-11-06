package racingcar.domain.strategy;

import java.util.Random;

public class RandomStrategy implements MoveStrategy {
    private Random random;

    private RandomStrategy() {
        random = new Random();
    }

    public static RandomStrategy getInstance() {
        return RandomStrategy.SingletonHelper.instance;
    }

    @Override
    public boolean checkMovable() {
        int bound = RandomStrategyConst.RANDOM_MAX;
        int biggerThan = RandomStrategyConst.RANDOM_BIGGER_THAN;
        int randomNum = random.nextInt(bound);
        return randomNum >= biggerThan;
    }

    private static class SingletonHelper {
        private static final RandomStrategy instance = new RandomStrategy();
    }
}

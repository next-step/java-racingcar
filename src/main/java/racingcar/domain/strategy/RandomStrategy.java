package racingcar.domain.strategy;

import racingcar.asset.RandomStrategyConst;

import java.util.Random;

public class RandomStrategy implements MoveStrategy {
    private Random random;

    private RandomStrategy() {
        random = new Random();
    }

    public static RandomStrategy getInstance() {
        return RandomStrategy.SingletonHelper.instance;
    }

    protected boolean checkMovable(int randomNum) {
        int upperBound = RandomStrategyConst.RANDOM_MAX;
        int lowerBound = RandomStrategyConst.RANDOM_MIN;
        int biggerThan = RandomStrategyConst.RANDOM_BIGGER_THAN;
        if (randomNum > upperBound) {
            return false;
        }
        if (randomNum < lowerBound) {
            return false;
        }
        if (randomNum < biggerThan) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkMovable() {
        int upperBound = RandomStrategyConst.RANDOM_MAX;
        int randomNum = random.nextInt(upperBound);
        return checkMovable(randomNum);
    }

    private static class SingletonHelper {
        private static final RandomStrategy instance = new RandomStrategy();
    }
}

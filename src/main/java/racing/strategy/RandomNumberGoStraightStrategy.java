package racing.strategy;

import java.util.Random;

public class RandomNumberGoStraightStrategy implements GoStraightStrategy {

    private static final int MOVE_NUMBER = 4;
    private static final int POSSIBLE_NUMBER = 10;
    private static RandomNumberGoStraightStrategy randomNumberGoStraightStrategy;

    private Random random = new Random();

    private RandomNumberGoStraightStrategy() {};

    public static RandomNumberGoStraightStrategy getInstance() {
        if (randomNumberGoStraightStrategy == null) {
            randomNumberGoStraightStrategy = new RandomNumberGoStraightStrategy();
        }
        return randomNumberGoStraightStrategy;
    }

    @Override
    public boolean isGoStraight() {
        return random.nextInt(POSSIBLE_NUMBER) >= MOVE_NUMBER;
    }
}

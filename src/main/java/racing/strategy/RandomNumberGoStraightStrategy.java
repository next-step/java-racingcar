package racing.strategy;

import java.util.Random;

public class RandomNumberGoStraightStrategy implements GoStraightStrategy {

    private static final int MOVE_NUMBER = 4;
    private static final int POSSIBLE_NUMBER = 10;

    private Random random = new Random();

    @Override
    public boolean isGoStraight() {
        return random.nextInt(POSSIBLE_NUMBER) >= MOVE_NUMBER;
    }
}

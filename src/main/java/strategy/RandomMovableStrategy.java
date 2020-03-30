package strategy;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MOVE_CONDITION = 4;
    private Random random = new Random();

    @Override
    public boolean isMove() {
        return random.nextInt(RANDOM_NUMBER_BOUND) >= MOVE_CONDITION ? true : false;
    }
}

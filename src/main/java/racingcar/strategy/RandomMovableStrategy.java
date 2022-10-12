package racingcar.strategy;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {

    private static final int BOUND = 10;
    private static final int THRESHOLD = 4;
    private Random randomGenerator = new Random();

    @Override
    public boolean canMove() {
        return randomGenerator.nextInt(BOUND) >= THRESHOLD;
    }
}

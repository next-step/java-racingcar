package step3.strategy;

import step3.util.RandomGenerator;

public class RandomNumMovingStrategy implements MovingStrategy {

    private static final int CONDITION = 4;

    @Override
    public boolean canForward() {
        return RandomGenerator.makeRandomInt() >= CONDITION;
    }
}

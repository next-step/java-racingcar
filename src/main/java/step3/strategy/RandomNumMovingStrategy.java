package step3.strategy;

import step3.util.RandomNumberGenerator;

public class RandomNumMovingStrategy implements MovingStrategy {

    private static final int BASE_NUM_FOR_MOVING = 4;

    @Override
    public boolean isForward() {
        return RandomNumberGenerator.makeRandomNumber() >= BASE_NUM_FOR_MOVING;
    }
}

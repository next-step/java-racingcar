package racingcar.domain;

import java.security.SecureRandom;

public class RandomMovableStrategy implements MovableStrategy {
    private static final int MAX_BOUND = 10;
    private static final int MOVABLE_NUMBER = 4;

    private SecureRandom secureRandom = new SecureRandom();

    @Override
    public boolean move() {
        return secureRandom.nextInt(MAX_BOUND) >= MOVABLE_NUMBER;
    }
}

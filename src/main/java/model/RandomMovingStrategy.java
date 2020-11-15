package model;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MAX_BOUND_VALUE = 10;
    private static final int REFERENCE_VALUE = 4;

    @Override
    public boolean movable () {
        return getRandomInteager() > REFERENCE_VALUE;
    }

    public int getRandomInteager () {
        return new Random().nextInt(MAX_BOUND_VALUE);
    }
}

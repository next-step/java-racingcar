package model;

import java.util.Random;


public class RandomMove implements MoveStrategy {
    private static final int BOUNDARY_VALUE = 4;
    private static final int BOUND = 10;
    private static final Random RANDOM = new Random();

    public RandomMove() {
    }

    @Override
    public boolean movable() {
        return RANDOM.nextInt(BOUND) >= BOUNDARY_VALUE;
    }
}

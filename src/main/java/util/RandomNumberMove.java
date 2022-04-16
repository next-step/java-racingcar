package util;

import java.util.Random;

public class RandomNumberMove implements MoveStrategy{
    private static final Random random = new Random();
    private static final int MAX = 9;
    private static final int BOUNDARY = 4;
    private static final RandomNumberMove instance = new RandomNumberMove();

    private RandomNumberMove() {
    }

    public static RandomNumberMove getInstance() {
        return instance;
    }

    @Override
    public boolean isMovable() {
        return BOUNDARY <= random.nextInt(MAX + 1);
    }
}

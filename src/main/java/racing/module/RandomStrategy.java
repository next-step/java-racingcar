package racing.module;

import java.util.Random;

public class RandomStrategy implements MoveStrategy{
    private static final int BOUNDARY_NUMBER = 3;
    private static final int RANDOM_BOUNDARY_NUMBER = 10;
    private final Random RANDOM = new Random();

    @Override
    public boolean canMove() {
        return getRandomNumber() > BOUNDARY_NUMBER;
    }

    public int getRandomNumber() {
        return RANDOM.nextInt(RANDOM_BOUNDARY_NUMBER);
    }
}

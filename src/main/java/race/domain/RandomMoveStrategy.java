package race.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{
    private static final int MOVE_CONDITION_NUMBER = 4;
    private static final int RANDOM_NUMBER_LIMIT = 10;
    private static final Random random = new Random();
    private static RandomMoveStrategy INSTANCE = null;

    public static RandomMoveStrategy getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RandomMoveStrategy();
        }
        return INSTANCE;
    }

    @Override
    public boolean isMovable() {
        return isMovable(generateRandomNumber());
    }

    public boolean isMovable(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    private int generateRandomNumber() {
        return this.random.nextInt(RANDOM_NUMBER_LIMIT);
    }
}

package step4.racing.move;

import java.util.Random;

public class RandomMove implements MoveInterface {
    public static Random ranoRandom = new Random();
    private static final int RANGE_OF_RANDOM_NUMBER = 10;
    private static final int NUMBER_OF_MOVEABLE = 4;

    @Override
    public boolean isMovable() {
        return ranoRandom.nextInt(RANGE_OF_RANDOM_NUMBER) >= NUMBER_OF_MOVEABLE;
    }

    @Override
    public boolean isTestMovable() {
        return true;
    }
}

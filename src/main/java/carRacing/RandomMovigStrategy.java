package carRacing;

import java.util.Random;

public class RandomMovigStrategy implements CarMovingStrategy{

    private static final int MOVE_STANDARD = 4;
    private static final int MAX_BOUNDS = 10;
    private final Random random = new Random();

    @Override
    public boolean isMove() {
        return getRandomNumber() >= MOVE_STANDARD;
    }

    private int getRandomNumber() {
        return random.nextInt(MAX_BOUNDS);
    }
}

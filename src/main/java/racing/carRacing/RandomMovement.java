package racing.carRacing;

import java.util.Random;

public class RandomMovement implements MovementStrategy{
    public static final Random RANDOM = new Random(System.currentTimeMillis());
    public static final int MAX_VALUE = 9;
    public static final int BOUNDARY = MAX_VALUE + 1;

    @Override
    public int movement() {
        return RANDOM.nextInt(BOUNDARY);
    }
}

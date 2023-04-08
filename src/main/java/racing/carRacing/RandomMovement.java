package racing.carRacing;

import java.util.Random;

public class RandomMovement implements MovementStrategy{
    public static Random RANDOM = new Random(System.currentTimeMillis());
    public static int MAX_VALUE = 9;
    public static int BOUNDARY = MAX_VALUE + 1;

    @Override
    public int movement() {
        return RANDOM.nextInt(BOUNDARY);
    }
}

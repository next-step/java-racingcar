package carracing.domain;

import java.util.Random;

public class RandomNumberMovingStrategy implements MovingStrategy{

    public static final int MAX_BOUND = 10;
    private static final int CAN_MOVE_THRESHOLD = 4;

    @Override
    public boolean movable() {
        return getRandomNo()>=CAN_MOVE_THRESHOLD;
    }

    private int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}

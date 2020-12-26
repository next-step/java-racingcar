package step5.domain;

import java.util.Random;

public class CarMovingStrategy implements MovingStrategy{
    private final Random random = new Random();
    private static final int MOVE_CONDITION = 4;
    private static final int RAN_NUMBER_RANGE = 10;

    @Override
    public boolean movable() {
        return MOVE_CONDITION <= randomNumber();
    }

    private int randomNumber() {
        return random.nextInt(RAN_NUMBER_RANGE);
    }
}

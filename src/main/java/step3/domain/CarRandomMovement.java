package step3.domain;

import java.util.Random;

public class CarRandomMovement implements CarMovement{
    private static final int MOVEMENT_MIN = 0;
    private static final int MOVEMENT_MAX = 9;
    private static final Random random = new Random();

    @Override
    public boolean canMove() {
        return getRandomValue() >= 4;
    }

    private Integer getRandomValue() {
        return random.nextInt(MOVEMENT_MAX - MOVEMENT_MIN + 1) + MOVEMENT_MIN;
    }
}

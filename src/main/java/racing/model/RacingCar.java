package racing.model;

import java.util.Random;

public class RacingCar implements Car {
    private static final Random RANDOM = new Random();

    private static final int MOVEABLE_NUMBER = 4;
    private static final int RANDOM_RANGE = 10;

    private int location = 0;

    @Override
    public void move() {
        if (moveCondition()) {
            location++;
        }
    }

    @Override
    public int currentLocation() {
        return location;
    }

    private Boolean moveCondition() {
        return RANDOM.nextInt(RANDOM_RANGE) > MOVEABLE_NUMBER;
    }
}

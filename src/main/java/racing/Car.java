package racing;

import java.util.Random;

public class Car {
    private static final int START_LOCATION = 0;
    private static final int MOVE_NUMBER = 4;
    private static final int POSSIBLE_NUMBER = 10;
    private Random random = new Random();
    private int currentLocation;
    private int advanceCondition;

    public Car() {
        this.currentLocation = START_LOCATION;
    }

    public void resetAdvanceCondition() {
        this.advanceCondition = random.nextInt(POSSIBLE_NUMBER);
    }

    public boolean isGoStraight() {
        return this.advanceCondition >= MOVE_NUMBER;
    }

    public void goStraight() {
        this.currentLocation++;
    }

    public int getCurrentLocation() {
        return this.currentLocation;
    }
}

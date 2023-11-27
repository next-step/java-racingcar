package study.race.model;

import java.util.Random;

public class Location {

    private static final int STARTING_POINT = 0;
    private static final int FORWARD = 1;
    private static final int FORWARD_CONDITION_THRESHOLD = 4;
    private static final int RANDOM_LIMIT_NUMBER = 10;

    private int location;
    private Random random;

    public Location() {
        this.location = STARTING_POINT;
        random = new Random();
    }

    public void updateMovingDistance() {
        if (checkForwardCondition()) {
            this.location += FORWARD;
        }
    }

    private boolean checkForwardCondition() {
        return random.nextInt(RANDOM_LIMIT_NUMBER) >= FORWARD_CONDITION_THRESHOLD;
    }

    public int getLocation() {
        return this.location;
    }
}

package step3_racing_car;

import java.util.Random;

public class RacingCar {
    public static final int RANDOM_RANGE = 10;
    public static final int MOVING_THRESHOLD = 4;
    int position = 0;

    public int getPosition() {
        return position;
    }

    public void movePositions(int distance) {
        this.position += distance;
    }
}

package racingcar;

import java.util.Random;

public class RacingCar {

    private static final Random random = new Random();
    private int distance = 0;

    public void move() {
        if (this.isMovable()) {
            distance++;
        }
    }

    private boolean isMovable() {
        return random.nextInt(10) >= 4;
    }

    public String getLocationString() {
        return "-".repeat(distance);
    }
}

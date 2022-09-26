package racingcar;

import java.util.Random;

public class RacingCar {

    private static final Random RANDOM = new Random();
    private int distance = 0;

    public void move() {
        if (this.isMovable()) {
            distance++;
        }
    }

    private boolean isMovable() {
        return RANDOM.nextInt(10) >= 4;
    }

    public String getLocationString() {
        return "-".repeat(distance);
    }
}

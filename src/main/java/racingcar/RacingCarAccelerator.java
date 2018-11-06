package racingcar;

import java.util.Random;

public class RacingCarAccelerator {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_MAX = 10;

    private int maxSpeed;

    public RacingCarAccelerator(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int speedUp() {
        return maxSpeed < RANDOM.nextInt(RANDOM_MAX) ? 1 : 0 ;
    }
}

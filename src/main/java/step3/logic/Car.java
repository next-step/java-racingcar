package step3.logic;

import java.util.Random;

public class Car {
    static final int THROTTLE_MIN = 0;
    static final int THROTTLE_MAX = 10;
    static final int THROTTLE_MOVE_MIN = 4;

    private final Random random = new Random();
    private int position = 0;

    public void run(int throttle) {
        if (throttle < THROTTLE_MIN || throttle >= THROTTLE_MAX) {
            throw new IllegalArgumentException("invalid throttle range");
        }

        if (throttle > THROTTLE_MOVE_MIN) {
            position += 1;
        }
    }

    public int getThrottle() {
        return random.nextInt(THROTTLE_MAX);
    }

    public int getCurrentPosition() {
        return position;
    }
}

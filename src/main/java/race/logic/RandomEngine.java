package race.logic;

import java.util.Random;

public class RandomEngine implements Engine {
    static final int THROTTLE_MAX = 10;
    static final int THROTTLE_MOVE_MIN = 4;

    private final Random random = new Random();

    @Override
    public boolean canMove() {
        int throttle = random.nextInt(THROTTLE_MAX);
        return throttle > THROTTLE_MOVE_MIN;
    }
}

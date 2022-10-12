package racing.domain;

import java.util.Random;

public class CarMovableStrategy implements MovableStrategy {

    private static final int RANDOM_RANGE = 10;
    private static final int RACING_CONDITION = 4;

    private final Random RANDOM = new Random();

    @Override
    public boolean randomMovable() {
        int random = RANDOM.nextInt(RANDOM_RANGE);
        return RACING_CONDITION <= random;
    }
}

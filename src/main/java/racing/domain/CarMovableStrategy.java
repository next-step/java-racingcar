package racing.domain;

import java.util.Random;

public class CarMovableStrategy implements MovableStrategy {

    private final static int RANDOM_RANGE = 10;
    private final static int RACING_CONDITION = 4;
    private final static Random RANDOM = new Random();

    @Override
    public int randomMovable() {
        int random = RANDOM.nextInt(RANDOM_RANGE);
        if(RACING_CONDITION <= random) {
            return 1;
        }
        return 0;
    }
}

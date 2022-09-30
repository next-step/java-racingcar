package car.strategy;

import java.util.Random;

public class CarMovableStrategy implements MovableStrategy {
    private static final int RACING_CONDITION = 4;

    @Override
    public boolean isMovable() {
        Random random = new Random();
        return RACING_CONDITION <= random.nextInt(10);
    }
}

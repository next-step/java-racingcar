package carracing.domain.car.strategy;

import java.util.Random;

public class CarPowerCondition implements CarCondition {

    private static final int MOVE_POSITION = 4;
    private int power;

    public CarPowerCondition() {
        this.power = getPower();
    }

    public int getPower() {
        Random random = new Random();
        return random.nextInt(10);
    }

    @Override
    public boolean isMovable() {
        return power >= MOVE_POSITION;
    }
}

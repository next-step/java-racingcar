package step5;

import step5.strategy.MovingStrategy;

public class SpeedMovingStrategyTest implements MovingStrategy {

    private final int speed;

    public SpeedMovingStrategyTest(int speed) {
        this.speed = speed;
    }

    @Override
    public int move() {
        return speed;
    }
}

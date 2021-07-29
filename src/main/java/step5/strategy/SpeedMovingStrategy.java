package step5.strategy;

import step5.strategy.MovingStrategy;

public class SpeedMovingStrategy implements MovingStrategy {

    private final int speed;

    public SpeedMovingStrategy(int speed) {
        this.speed = speed;
    }

    @Override
    public int move() {
        return speed;
    }
}

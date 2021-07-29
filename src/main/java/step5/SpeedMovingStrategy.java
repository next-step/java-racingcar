package step5;

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

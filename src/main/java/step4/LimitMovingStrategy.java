package step4;

public class LimitMovingStrategy implements MovingStrategy {

    private final int speed;

    public LimitMovingStrategy(int speed) {
        this.speed = speed;
    }

    @Override
    public int move() {
        return speed;
    }
}

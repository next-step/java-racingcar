package carracing.domain;

public class CarPowerCondition implements CarCondition {

    private static final int MOVE_POSITION = 4;
    private int power;
    public CarPowerCondition(int power) {
        this.power = power;
    }

    @Override
    public boolean isMovable() {
        return power >= MOVE_POSITION;
    }
}

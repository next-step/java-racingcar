package racingcar.domain.car;

public class FixedPower implements Power {
    private boolean movable;

    public FixedPower() {
        this.movable = false;
    }

    @Override
    public boolean isMovable() {
        movable = !movable;
        return movable;
    }
}

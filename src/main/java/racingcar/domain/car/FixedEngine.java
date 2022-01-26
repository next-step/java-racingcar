package racingcar.domain.car;

public class FixedEngine implements Engine {

    private boolean isMovable;

    public FixedEngine(boolean isMovable) {
        this.isMovable = isMovable;
    }

    @Override
    public boolean movable() {
        return isMovable;
    }
}

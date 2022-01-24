package racingcar.domain;

public class FixedEngine implements Engine {

    private boolean isMovable;

    protected FixedEngine(boolean isMovable) {
        this.isMovable = isMovable;
    }

    @Override
    public boolean movable() {
        return isMovable;
    }
}

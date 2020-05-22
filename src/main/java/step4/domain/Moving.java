package step4.domain;

public class Moving {

    private MovableStrategy movableStrategy;

    public Boolean isMovable() {
        return movableStrategy.isMovable();
    }

    public void setMovableStrategy(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }
}

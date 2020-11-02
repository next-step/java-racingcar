package step3.domain;

public class RacingCar {
    private final MovableStrategy movableStrategy;

    private final String name;

    public RacingCar(final String name, final MovableStrategy movableStrategy) {
        this.name = name;
        this.movableStrategy = movableStrategy;
    }

    public String getName() {
        return name;
    }

    public int getStartPosition() {
        return 0;
    }

    public boolean isMovable() {
        return movableStrategy.isMovable();
    }
}

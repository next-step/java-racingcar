package model;

public class RacingCar {
    private final RacingCarStatus status;
    private final MovableStrategy movableStrategy = new RandomMovableStrategy();

    public RacingCar() {
        this.status = new RacingCarStatus();
    }

    public void move() {
        if (movableStrategy.isMovable()) {
            status.add();
        }
    }

    public int getStatus() {
        return this.status.getValue();
    }
}

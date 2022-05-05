package racingcar.model;

public class RacingCar {
    private RacingCarPosition status;
    private final MovableStrategy movableStrategy = new RandomMovableStrategy();

    public RacingCar() {
        this.status = new RacingCarPosition();
    }

    public void move() {
        if (movableStrategy.isMovable()) {
            this.status = status.add();
        }
    }

    public int getStatus() {
        return this.status.getValue();
    }
}

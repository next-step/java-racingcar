package racinggame;

public class RacingCar {

    private final MovableStrategy movableStrategy;
    private int position;

    private RacingCar(MovableStrategy movableStrategy) {
        validateRacingCar(movableStrategy);
        this.movableStrategy = movableStrategy;
    }

    public static RacingCar newInstance(MovableStrategy movableStrategy) {
        return new RacingCar(movableStrategy);
    }

    private void validateRacingCar(MovableStrategy movableStrategy) {
        if (movableStrategy == null) {
            throw new IllegalArgumentException("이동 전략이 존재하지 않습니다.");
        }
    }

    public void move() {
        if (movableStrategy.isMovable()) {
            this.position++;
        }
    }

    public int currentPosition() {
        return this.position;
    }
}

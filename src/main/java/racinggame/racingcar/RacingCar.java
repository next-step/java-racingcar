package racinggame.racingcar;

public class RacingCar {
    private final CarPosition position;
    private final MoveStrategy moveStrategy;

    private RacingCar(CarPosition position, MoveStrategy moveStrategy) {
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public static RacingCar create(MoveStrategy moveStrategy) {
        return new RacingCar(new CarPosition(), moveStrategy);
    }

    public void move() {
        if (moveStrategy.shouldMove()) {
            position.moveForward();
        }
    }

    int getCurrentPosition() {
        return position.getCurrentValue();
    }
}

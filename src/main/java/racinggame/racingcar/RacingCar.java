package racinggame.racingcar;

public class RacingCar {
    private final CarPosition position;
    private final MoveStrategy moveStrategy;

    RacingCar(CarPosition position, MoveStrategy moveStrategy) {
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    boolean isAtStartPosition() {
        return position.isAtStart();
    }

    void move() {
        if (moveStrategy.shouldMove()) {
            position.moveForward();
        }
    }

}
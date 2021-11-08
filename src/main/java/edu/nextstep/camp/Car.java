package edu.nextstep.camp;

public class Car {
    private final Position position;
    private final MovePolicy movePolicy;

    public Car() {
        this.position = Position.of(0);
        this.movePolicy = new DefaultMovePolicy();
    }

    public Car(MovePolicy movePolicy) {
        this.position = Position.of(0);
        this.movePolicy = movePolicy;
    }

    public Position position() {
        return position;
    }

    public void attemptToMove() {
        if (movePolicy.needToMove()) {
            position.forward();
        }
    }
}

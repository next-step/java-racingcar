package edu.nextstep.camp;

public class Car {
    private final Position position;
    private final MovePolicy movePolicy;

    public Car() {
        this.position = Position.ofZero();
        this.movePolicy = new RandomMovePolicy();
    }

    public Car(MovePolicy movePolicy) {
        if (movePolicy == null) {
            throw new IllegalArgumentException("move policy cannot be null.");
        }

        this.position = Position.ofZero();
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

package edu.nextstep.camp.racinggame.domain.car;

import edu.nextstep.camp.racinggame.domain.car.policy.MovePolicy;

public class Car {
    private final Name name;
    private final Position position;
    private final MovePolicy movePolicy;

    private Car(Name name, MovePolicy movePolicy) {
        this.name = name;
        this.position = Position.ofZero();
        this.movePolicy = movePolicy;
    }

    public static Car of(Name name, MovePolicy movePolicy) {
        if (movePolicy == null) {
            throw new IllegalArgumentException("move policy cannot be null.");
        }

        return new Car(name, movePolicy);

    }

    public Position position() {
        return position;
    }

    public boolean isPositionOf(Position position) {
        return this.position.equals(position);
    }

    public void attemptToMove() {
        if (movePolicy.needToMove()) {
            position.forward();
        }
    }

    public Name name() {
        return name;
    }
}

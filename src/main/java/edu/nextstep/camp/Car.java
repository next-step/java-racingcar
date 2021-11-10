package edu.nextstep.camp;

public class Car {
    public static final int NAME_LIMIT = 5;

    private final String name;
    private final Position position;
    private final MovePolicy movePolicy;

    private Car(String name, MovePolicy movePolicy) {
        this.name = name;
        this.position = Position.ofZero();
        this.movePolicy = movePolicy;
    }

    public static Car of(String name, MovePolicy movePolicy) {
        if (name == null || name.isEmpty() || name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("invalid name: " + name);
        }

        if (movePolicy == null) {
            throw new IllegalArgumentException("move policy cannot be null.");
        }

        return new Car(name, movePolicy);

    }

    public Position position() {
        return position;
    }

    public void attemptToMove() {
        if (movePolicy.needToMove()) {
            position.forward();
        }
    }

    public String name() {
        return name;
    }
}

package domain;

public class Car {

    private final Name name;
    private final Position position;
    private final MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this(Name.createDefaultInstance(), moveStrategy);
    }

    public Car(Name name, MoveStrategy moveStrategy) {
        this.name = name;
        this.position = new Position();
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.moveable()) {
            position.moveForward();
        }
    }

    public Position position() {
        return this.position;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, "-".repeat(position.getValue() + 1));
    }

    public Name name() {
        return this.name;
    }
}

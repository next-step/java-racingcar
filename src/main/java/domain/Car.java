package domain;

public class Car {

    private final Position position;
    private final MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this.position = new Position();
        this.moveStrategy = moveStrategy;
    }

    public Position move() {
        if (moveStrategy.moveable()) {
            position.moveForward();
        }
        return position;
    }

    public Position position() {
        return this.position;
    }

    @Override
    public String toString() {
        return "-".repeat(position.getValue() + 1);
    }
}

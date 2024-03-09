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
            position.move();
        }
        return position;
    }

    public Position position() {
        return this.position;
    }
}

package racinggame.car;

public class Car {

    private Position position;

    public Car() {
        this.position = Position.from();
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position = this.position.forward();
        }
    }

    public Position position() {
        return position;
    }

}

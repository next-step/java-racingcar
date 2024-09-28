package racinggame.car;

public class Car {

    private Position position;

    public Car() {
        this.position = Position.of();
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position = this.position.forward();
        }
    }

    public int position() {
        return position.value();
    }

}

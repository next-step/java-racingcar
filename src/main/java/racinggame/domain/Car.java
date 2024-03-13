package racinggame.domain;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move(MovingStrategy MovingStrategy) {
        if (MovingStrategy.isMoving()) {
            position = position.move();
        }
    }

    public Position getPosition() {
        return this.position;
    }
}

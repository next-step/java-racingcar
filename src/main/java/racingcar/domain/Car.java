package racingcar.domain;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move(MovableStrategy movable) {
        if (movable.move()) {
            position = position.move();
        }
    }

    Position getPosition() {
        return position;
    }
}

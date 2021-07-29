package racingcar.domain;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move(MovableStrategy movable) {
        if (movable.canMove()) {
            position = new Position(position.getPosition() + 1);
        }
    }

    public Position getPosition() {
        return position;
    }
}

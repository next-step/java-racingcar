package racingcar.domain;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move(Movable movable) {
        if (movable.move()) {
            position = position.move();
        }
    }

    public Position getPosition() {
        return position;
    }
}

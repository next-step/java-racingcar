package racingcar.domain;

public class Car {

    private Position position;

    public Car(int initPosition) {
        this.position = new Position(initPosition);
    }

    public Car() {
        this.position = new Position();
    }

    public void moveForward(RandomMoveStrategy strategy) {
        if (strategy.movable()) {
            position = position.move();
        }
    }

    public Position getPosition() {
        return position;
    }
}


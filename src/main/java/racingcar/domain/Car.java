package racingcar.domain;

public class Car {

    private Position position;

    public Car(int initPosition) {
        this.position = new Position(initPosition);
    }

    public Car() {
        this.position = new Position();
    }

    public void moveForward() {
        position.move();
    }

    public Position getPosition() {
        return position;
    }
}


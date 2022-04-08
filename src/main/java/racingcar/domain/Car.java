package racingcar.domain;

public class Car {

    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move() {
        this.position = position.move();
    }

    public int position() {
        return position.getPosition();
    }
}

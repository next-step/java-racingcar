package racingcar.domain;

public class Car {

    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move() {
        this.position = new Position(position() + 1);
    }

    public int position() {
        return position.getValue();
    }
}

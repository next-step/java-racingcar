package racingcar.car;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public Position getPosition() {
        return this.position;
    }
}

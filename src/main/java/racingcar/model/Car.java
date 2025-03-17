package racingcar.model;


public class Car {

    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public Car(int initialPosition) {
        this.position = new Position(initialPosition);
    }

    public void move() {
        position.incrementPosition();
    }

    public boolean isAtPosition(Position other) {
        return position.isSameAs(other);
    }

    public void print() {
        System.out.println(position);
    }
}

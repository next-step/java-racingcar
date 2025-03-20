package racingcar.model;


public class Car {

    private final Position position;

    private static final int MOVE_CONDITION_NUMBER = 4;

    public Car() {
        this(0);
    }

    public Car(int initialPosition) {
        this.position = new Position(initialPosition);
    }

    private Car(Position position) {
        this.position = position;
    }

    public Car move(int randomValue) {
        if (canMove(randomValue)) {
            return new Car(this.position.incrementPosition());
        }
        return this;
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MOVE_CONDITION_NUMBER;
    }

    public boolean isAtPosition(Position other) {
        return position.isSameAs(other);
    }

    public void printPosition() {
        System.out.println(position);
    }
}

package racingcar.model;


public class Car {

    private final Position position;
    private static final int MOVE_CONDITION_NUMBER = 4;

    public Car() {
        this.position = new Position();
    }

    public Car(int initialPosition) {
        this.position = new Position(initialPosition);
    }

    public void move(int randomValue) {
        if (canMove(randomValue)) {
            position.incrementPosition();
        }
    }

    private static boolean canMove(int randomValue) {
        return randomValue >= MOVE_CONDITION_NUMBER;
    }

    public boolean isAtPosition(Position other) {
        return position.isSameAs(other);
    }

    public void print() {
        System.out.println(position);
    }
}

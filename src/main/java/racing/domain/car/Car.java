package racing.domain.car;

public class Car {

    private static final int STANDARD_NUMBER_MOVE_FORWARD = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int value) {
        this.name = new Name(name);
        this.position = new Position(value);
    }

    public boolean isSamePosition(final Position position) {
        return this.position.equals(position);
    }

    public void drive(int randomNumber) {
        if (isMovable(randomNumber)) {
            position = position.move();
        }
    }

    private boolean isMovable(final int randomNumber) {
        return randomNumber >= STANDARD_NUMBER_MOVE_FORWARD;
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}

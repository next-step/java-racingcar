package racing.domain;

public class Car {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int STANDARD_NUMBER_MOVE_FORWARD = 4;

    private final Name name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }

    public void drive(int randomNumber) {
        if (isMovable(randomNumber)) {
            this.position++;
        }
    }

    private boolean isMovable(final int randomNumber) {
        return randomNumber >= STANDARD_NUMBER_MOVE_FORWARD;
    }

    public int getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}

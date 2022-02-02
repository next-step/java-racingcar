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

    public void drive(int condition) {
        if (condition >= STANDARD_NUMBER_MOVE_FORWARD)) {
            position = position.move();
        }
    }

    public int getPositionValue() {
        return position.getValue();
    }

    public Name getName() {
        return name;
    }
}

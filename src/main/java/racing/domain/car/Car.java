package racing.domain.car;

public class Car {

    private static final int STANDARD_NUMBER_MOVE_FORWARD = 4;
    private static final int INITIATE_POSITION_VALUE = 0;

    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, INITIATE_POSITION_VALUE);
    }

    public Car(String name, int value) {
        this.name = new Name(name);
        this.position = new Position(value);
    }

    public Car(Name name, Position position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public boolean isSamePosition(final Position position) {
        return this.position.equals(position);
    }

    public void drive(int condition) {
        if (condition >= STANDARD_NUMBER_MOVE_FORWARD) {
            position = position.move();
        }
    }

    public int getPositionValue() {
        return position.getValue();
    }

    public String getNameValue() {
        return name.getValue();
    }
}

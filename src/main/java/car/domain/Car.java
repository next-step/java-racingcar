package car.domain;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_STEP = 1;
    private int position;
    private final Name name;

    public Car(final String name) {
        this(0, name);
    }

    public Car(final int position, final String name) {
        this.position = position;
        this.name = new Name(name);
    }

    public void move(final int value) {
        if (value >= MOVE_THRESHOLD) {
            position += MOVE_STEP;
        }
    }

    public String getNameValue() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public boolean positionIsEqualTo(final int position) {
        return this.position == position;
    }
}

package racingcar.domain.car;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int THRESHOLD_TO_MOVE = 4;
    private static final int MOVE_ONE_STEP = 1;

    private final Name name;
    public final int position;

    private Car(final String name) {
        this(name, INITIAL_POSITION);
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    public static Car of(final String name, final int position) {
        return new Car(name, position);
    }

    public Car go(int fuel) {
        int newPosition = this.position;
        if (fuel > THRESHOLD_TO_MOVE) {
            newPosition += MOVE_ONE_STEP;
            return Car.of(name.getName(), newPosition);
        }

        return this;
    }

    public boolean isSamePosition(Car other) {
        return position == other.position;
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }
}

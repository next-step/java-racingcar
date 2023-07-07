package racingcar.domain;

public final class Car {

    private static final int START_POSITION = 0;
    public static final int MOVE_UPPER_BOUND = 3;
    private final Name name;
    private final Position position;

    private Car(final String name) {
        this(name, START_POSITION);
    }

    private Car(final String name, final int position) {
        this.name = Name.from(name);
        this.position = Position.from(position);
    }

    public static Car create(final String name) {
        return new Car(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void moveForward() {
        this.position.increase();
    }
}

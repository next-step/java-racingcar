package racing.domain.model;

public class Car {

    private final int INITIAL_POSITION = 1;
    private final String name;
    private int position = INITIAL_POSITION;

    public Car(final String name) {
        this.name = name;
    }

    public int moveForward() {
        return ++position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

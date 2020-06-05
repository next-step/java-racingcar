package racing.domain;

public class Car {
    private static final int MOVE_DISTANCE = 1;

    private final String name;
    private int location;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void move(final boolean isMovable) {
        if (isMovable) {
            location += MOVE_DISTANCE;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}

package racing.domain;

public class Car {

    private final String name;
    private int position = 1;

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

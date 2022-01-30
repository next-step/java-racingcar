package racinggame.domain;

public class Car {

    private static final int DEFAULT_LOCATION = 0;
    private static final int FORWARD_NUMBER = 4;

    private final CarName name;
    private int location;

    public Car(final String name) {
        this(name, DEFAULT_LOCATION);
    }

    public Car(final String name, int location) {
        this.name = new CarName(name);
        this.location = location;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void moveForward(final int randomNumber) {
        if (randomNumber >= FORWARD_NUMBER) {
            this.location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name.get();
    }
}

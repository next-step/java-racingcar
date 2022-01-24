package racinggame.domain;

public class Car {

    private final String name;
    private int location;

    public Car(final String name) {
        this.name = name;
        this.location = 0;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

}

package racing.domain;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this(new Name(name), new Position());
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car goForward(boolean trigger) {
        if (trigger) {
            return new Car(this.name, this.position.next());
        }
        return new Car(this.name, this.position);
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name.getName();
    }
}

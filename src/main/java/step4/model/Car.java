package step4.model;

public class Car {

    private Position position;
    private final Name name;

    public Car(Name name) {
        this.name = name;
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getName() {
        return this.name;
    }
}

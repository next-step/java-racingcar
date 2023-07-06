package racing.domain;

public class Car {
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void goForward(boolean trigger) {
        if (trigger) {
            this.position = this.position.next();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name.getName();
    }
}

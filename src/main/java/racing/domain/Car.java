package racing.domain;

public class Car {

    private final String name;

    private final Position position;

    public Car(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, new Position());
    }

    public void move() {
        position.move();
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}

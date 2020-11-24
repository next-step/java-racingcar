package racing.domain;

public class Car {

    private final String name;

    private Position position;

    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public Car(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move() {
        position = position.move();
    }
}

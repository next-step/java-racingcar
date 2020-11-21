package racing.domain;

public class Car {

    private final Name name;

    private final Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Car(String name) {
        this(name, 0);
    }

    public void move() {
        position.move();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}

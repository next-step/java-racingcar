package racing.domain;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(Movable movable) {
        if (movable.isMovable()) {
            position.move();
        }
    }

    public boolean isLocatedAt(int maxPosition) {
        return this.position.isSameWith(maxPosition);
    }

    public Position position() {
        return position;
    }

    public Name name() {
        return name;
    }
}

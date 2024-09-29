package racinggame.car;

public class Car {

    private Name name;
    private Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position = this.position.forward();
        }
    }

    public Name name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }

}

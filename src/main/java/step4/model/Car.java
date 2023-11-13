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

    public void go(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position.move();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getName() {
        return this.name;
    }
}

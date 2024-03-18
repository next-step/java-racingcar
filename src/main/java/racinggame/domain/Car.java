package racinggame.domain;

public class Car {
    private Position position;
    private Name name;

    public Car(String name) {
        this.name = Name.create(name);
        this.position = Position.create();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMoving()) {
            position = position.move();
        }
    }

    public Position getMaxPosition(Position otherPosition) {
        if (this.position.isGreater(otherPosition)) {
            return this.position;
        }
        return otherPosition;
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getName() {
        return name;
    }
}

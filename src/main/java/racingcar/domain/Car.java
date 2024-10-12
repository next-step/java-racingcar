package racingcar.domain;


public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(name, new Position());
    }

    public Car(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position.increase();
        }
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }
}

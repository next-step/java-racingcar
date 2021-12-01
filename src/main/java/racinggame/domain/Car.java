package racinggame.domain;

public class Car {
    private final Name name;
    private Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this(new Name(name), new Position(position));
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public boolean isWinner(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public void move(RandomValue randomValue) {
        if (randomValue.isMovable())
            this.position.move();
    }

    public Position maxPosition(Position maxPosition) {
        if (this.position.isBiggerThan(maxPosition)) {
            return this.position;
        }
        return maxPosition;
    }
}

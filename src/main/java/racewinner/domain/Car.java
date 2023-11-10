package racewinner.domain;


public class Car {
    private final static int FORWARD_NUMBER = 4;
    private final Name name;
    private final Position position;

    public Car(final String name) {
        this(name, new Position(0));
    }
    public Car(final String name, final Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void move(final int number) {
        if (isMovable(number)) {
            position.move();
        }
    }

    private boolean isMovable(int number) {
        return FORWARD_NUMBER <= number;
    }
    String name() { return name.get(); }

    public boolean isWinner(final Position position) {
        return this.position.equals(position);
    }

    public Position max(Position position) {
        if (this.position.isGreaterThan(position)) {
            return this.position;
        }

        return position;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name.get(), position);
    }
}

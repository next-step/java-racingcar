package racingcarfinal.domain;

public class Car {

    private static final int MOVE_BOUND = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int moveValue) {
        if (moveValue >= MOVE_BOUND) {
            position = position.move();
        }
    }

    public boolean isSamePosition(Position other) {
        return this.position.equals(other);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

}

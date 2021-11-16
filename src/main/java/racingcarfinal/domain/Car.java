package racingcarfinal.domain;

public class Car {

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
        if (moveValue >= 4) {
            position = position.increase();
        }
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getName() {
        return name;
    }

}

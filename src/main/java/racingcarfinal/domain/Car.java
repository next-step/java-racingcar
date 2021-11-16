package racingcarfinal.domain;

public class Car {

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(int moveValue) {
        if (moveValue >= 4) {
            position = position.increase();
        }
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

}

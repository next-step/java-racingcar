package racingcargamefinal.domain;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(new Name(name), Position.ZERO);
    }

    public Car(String name, int value) {
        this(new Name(name), new Position(value));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move(MoveValue moveValue) {
        if (moveValue.canMove()) {
            return new Car(name, position.move());
        }
        return this;
    }

    public Position findMaxPosition(Position ohter) {
        return position.findBigger(ohter);
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

}

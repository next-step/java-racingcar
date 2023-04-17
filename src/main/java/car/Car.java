package car;

public class Car {
    private final Name name;
    private final Position position;
    private final MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.position = new Position();
        this.name = new Name(name);
        this.moveStrategy = moveStrategy;
    }

    public Name getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move() {
        if(moveStrategy.movable()) {
            position.move();
        }
    }

    public boolean isWinner(Position position) {
        return this.position.intValue() == position.intValue();
    }
}

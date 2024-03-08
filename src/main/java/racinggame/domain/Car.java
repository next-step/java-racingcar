package racinggame.domain;

public class Car {

    private Position position;

    public Car() {
        this(new Position(0));
    }

    public Car(Position position) {
        this.position = position;
    }

    public void run(MoveCondition condition) {
        if(condition.isMovable()) {
            position = position.add();
        }
    }

    public Position position() {
        return position;
    }
}

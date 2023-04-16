package race;

public class Car {
    private final Position position;
    private final MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this.position = new Position();
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.canMove()) {
            position.add();
        }
    }

    public Position getPosition() {
        return position;
    }
}

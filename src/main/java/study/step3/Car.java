package study.step3;

public class Car {
    private static final int FORWARD_VALUE = 4;
    private Position position;
    private MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this.position = new Position(0);
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.getValue() >= FORWARD_VALUE) {
            position.forward();
        }
    }

    public Position getPosition() {
        return position;
    }
}

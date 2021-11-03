package step3;

public class Car {
    private final MoveStrategy moveStrategy;
    private final static Integer BASE_POSITION = 0;
    private Position position;

    private Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.position = Position.create(BASE_POSITION);
    }

    public static Car create(MoveStrategy moveStrategy) {
        return new Car(moveStrategy);
    }

    public Position getPosition() {
        return position;
    }

    public void moveOrStop() {
        if (isGo()) {
            move();
        }
    }

    private void move() {
        this.position = this.position.move();
    }

    private boolean isGo() {
        return moveStrategy.test();
    }
}

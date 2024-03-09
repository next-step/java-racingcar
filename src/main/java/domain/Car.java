package domain;

public class Car {

    private int moveCount;
    private final Position position;
    private final MoveStrategy moveStrategy;

    public Car(int moveCount, MoveStrategy moveStrategy) {
        this.moveCount = moveCount;
        this.position = new Position();
        this.moveStrategy = moveStrategy;
    }

    public Position move() {
        if (!moveable()) {
            return position;
        }
        if (moveStrategy.moveable()) {
            position.move();
        }
        reduceMoveCount();
        return position;
    }

    private void reduceMoveCount() {
        this.moveCount--;
    }

    public boolean moveable() {
        return moveCount >= 1;
    }

    public Position position() {
        return this.position;
    }
}

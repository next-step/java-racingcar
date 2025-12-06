package racing.domain;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private Position position;

    public Car() {
        this.position = new Position(DEFAULT_POSITION);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position = position.move();
        }
    }

    public int getPosition() {
        return position.value();
    }
}

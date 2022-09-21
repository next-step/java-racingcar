package racingcar.domain;

public class Car {
    public static final int DEFAULT_MOVEMENT_DISTANCE = 1;

    private Position position;

    public Car(int position) {
        this.position = new Position(position);
    }

    public Car(Position position) {
        this.position = position;
    }

    public Car() {
        this(0);
    }

    public int position() {
        return position.getPosition();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position = position.add(new Position(DEFAULT_MOVEMENT_DISTANCE));
        }
    }
}

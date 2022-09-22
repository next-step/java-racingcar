package racingcar.domain;

public class Car {
    private static final int DEFAULT_MOVEMENT_DISTANCE = 1;

    private Position position;

    public Car(int position) {
        this.position = new Position(position);
    }

    public Car(Position position) {
        this.position = position;
    }

    public Car() {
        this(new Position());
    }

    public static Car of(Car car) {
        return new Car(car.position);
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

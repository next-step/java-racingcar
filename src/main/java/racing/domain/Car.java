package racing.domain;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private final CarName carName;
    private Position position;

    public Car(CarName carName) {
        this.carName = carName;
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

    public CarResult createCarResult() {
        return new CarResult(carName, position);
    }

    public boolean maxPosition(Position maxPosition) {
        return this.position.equals(maxPosition);
    }
}

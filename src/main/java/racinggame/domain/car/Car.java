package racinggame.domain.car;

public class Car {

    private static final int RACING_CAR_MOVING_BOUNDARY = 4;

    private final String carName;
    private final Position position;

    public Car(String carName) {
        this(carName, Position.getZeroPosition());
    }

    public Car(String carName, int position) {
        this(carName, new Position(position));
    }

    public Car(String carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public Car moveCar(int num) {
        if (num >= RACING_CAR_MOVING_BOUNDARY) {
            return new Car(this.carName, this.position.move());
        }
        return this;
    }

    public boolean isMovedFarThan(int compare) {
        return this.position.getPosition() >= compare;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getCarName() {
        return this.carName;
    }
}

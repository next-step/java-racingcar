package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private Position position;

    public Car(CarName name) {
        this.name = name;
        this.position = new Position();
    }

    public Car(String value) {
        this(new CarName(value));
    }

    public CarName name() {
        return name;
    }

    public Position position() {
        return position;
    }

    public void moveIfPossible(int number) {
        if (number >= MOVE_THRESHOLD) {
            position = position.move();
        }
    }

    public boolean isAtSamePositionAs(Car maxCar) {
        return this.position.equals(maxCar.position);
    }

    public boolean isAheadOf(Car car) {
        return this.position.asInt() > car.position.asInt();
    }
}

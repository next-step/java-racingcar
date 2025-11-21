package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private Position position;

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(CarName name) {
        this(name, new Position());
    }

    public Car(String name) {
        this(new CarName(name), new Position());
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

    public boolean isAtSamePositionAs(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public Position updateMax(Position maxPosition) {
        if (isAheadOf(maxPosition)) {
            return this.position;
        }
        return maxPosition;
    }

    public boolean isAheadOf(Position position) {
        return this.position.isGreaterThan(position);
    }
}

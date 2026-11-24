package racingcar.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private int position;

    public Car(CarName name) {
        this(name, 0);
    }

    public Car(CarName name, int position) {
        validateName(name);
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    private static void validateName(CarName name) {
        if (name == null) {
            throw new IllegalArgumentException("car name is required");
        }
    }

    private static void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position can not be negative value [" + position + "]");
        }
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public CarResult toResult() {
        return new CarResult(name, position);
    }

    public CarName getName() {
        return name;
    }
}

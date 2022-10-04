package racingcar.domain;

public class Car {
    public static final int MINIMUM_MOVE_VALUE = 4;

    private final int location;

    public Car() {
        this.location = 0;
    }

    public Car(int location) {
        this.location = location;
    }

    public int getLocation() {
        return this.location;
    }

    public Car move(Generator generator) {
        if (generator.nextValue() >= MINIMUM_MOVE_VALUE) {
            return new Car(this.location + 1);
        }
        return new Car(this.location);
    }
}

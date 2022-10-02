package racingcar.domain;

public class Car {
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

    public Car nextTurn(Generator generator) {
        if (generator.nextValue() >= 4) {
            return new Car(this.location + 1);
        }
        return new Car(this.location);
    }
}

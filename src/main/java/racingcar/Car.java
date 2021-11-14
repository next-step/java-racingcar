package racingcar;

public class Car {

    private final int location;

    public Car(int location) {
        this.location = location;
    }

    public Car move() {
        return new Car(this.location + Random.randomMove());
    }

    public int getLocation() {
        return location;
    }
}

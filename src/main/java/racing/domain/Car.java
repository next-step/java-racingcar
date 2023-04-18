package racing.domain;

public class Car {
    private int location;

    public Car(int location) {
        this.location = location;
    }

    public Car move(int distance) {
        this.location += distance;
        return new Car(this.location);
    }

    public int location() {
        return this.location;
    }
}

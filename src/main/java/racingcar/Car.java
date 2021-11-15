package racingcar;

public class Car {

    private final String name;
    private final int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public Car move() {
        return new Car(this.name, this.location + Random.randomMove());
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}

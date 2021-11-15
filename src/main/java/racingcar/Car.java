package racingcar;

public class Car {

    private final String name;
    private final int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public Car move(int move) {
        return new Car(this.name, this.location + move);
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}

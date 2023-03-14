package racingcar.v1;

public class Car {
    private final String name;
    private int distance;

    Car(String name) {
        this(name, 0);
    }

    Car(String name, int distance) {
        validate(name);
        this.name = name;
        this.distance = distance;
    }

    private void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void addDistance(int distance) {
        this.distance += distance;
    }
}

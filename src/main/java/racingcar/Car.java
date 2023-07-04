package racingcar;

public class Car {

    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    void forward() {
        distance++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance + 1);
    }

    public void progress() {
        int number = RandomGenerator.generateNumber();
        if (number >= 4) {
            forward();
        }
    }
}

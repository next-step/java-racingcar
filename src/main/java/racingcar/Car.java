package racingcar;

public class Car {

    private final String name;
    private int distance;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
        validateCarName(name);
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Error: Invalid car name");
        }
    }

    public void moveCarRandomly(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}

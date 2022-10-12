package racing.core;

public class Car {

    private static final int STEP_COUNT = 1;
    private int distance = 1;
    private final String carName;

    public Car(String carName) {
        if (carName == null || carName.equals("")) {
            throw new IllegalArgumentException("car name cannot be empty");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("car name length shouldn't be longer than 5");
        }
        this.carName = carName;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getCarName() {
        return this.carName;
    }

    public void stepAhead() {
        this.distance += STEP_COUNT;
    }

    @Override
    public String toString() {
        return carName;
    }
}

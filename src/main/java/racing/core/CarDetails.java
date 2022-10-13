package racing.core;

import java.util.Objects;

public class CarDetails {
    private int distance;
    private final String carName;
    private static final int STEP_COUNT = 1;

    public CarDetails(int distance, String carName) {
        if (carName == null || carName.equals("")) {
            throw new IllegalArgumentException("car name cannot be empty");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("car name length shouldn't be longer than 5");
        }
        if(distance < 1){
            throw new IllegalArgumentException("car distance should be bigger than 0");
        }
        this.distance = distance;
        this.carName = carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDetails carDetails = (CarDetails) o;
        return distance == carDetails.distance && Objects.equals(carName, carDetails.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, carName);
    }

    public int getDistance() {
        return this.distance;
    }

    public String getCarName() {
        return carName;
    }

    void stepAhead() {
        this.distance += STEP_COUNT;
    }
}

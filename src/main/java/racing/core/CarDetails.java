package racing.core;

import java.util.Objects;

public class CarDetails {
    private int distance;
    private final String carName;

    public CarDetails(int distance, String carName) {
        this.distance = distance;
        this.carName = carName;
    }
    public int getDistance() {
        return this.distance;
    }

    public String getCarName() {
        return carName;
    }
}

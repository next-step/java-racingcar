package racingcar;

import java.util.Objects;

public class CarLocationResult {

    private final String carName;

    private final int currentLocation;

    public CarLocationResult(Car car) {
        this.carName = car.getCarName();
        this.currentLocation = car.getCurrentLocation();
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarLocationResult)) return false;
        CarLocationResult that = (CarLocationResult) o;
        return currentLocation == that.currentLocation && Objects.equals(carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, currentLocation);
    }

}

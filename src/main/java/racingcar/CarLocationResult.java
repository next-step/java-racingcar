package racingcar;

import java.util.Objects;

public class CarLocationResult {

    private final String carName;

    private final int currentLocation;

    private CarLocationResult(String carName, int currentLocation) {
        this.carName = carName;
        this.currentLocation = currentLocation;
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

    public static CarLocationResult from(Car car) {
        return new CarLocationResult(car.getCarName(), car.getCurrentLocation());
    }

}

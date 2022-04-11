package racingcar.model;

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

    public static CarLocationResult from(Car car) {
        return new CarLocationResult(
                car.getCarNameValue(),
                car.getCurrentLocationValue()
        );
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

}

package step5;

public class RacingResult {

    private final String carName;
    private final int location;

    public RacingResult(Car car) {
        this.carName = car.getCarName();
        this.location = car.getLocation();
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }
}

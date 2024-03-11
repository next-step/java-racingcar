package racingCar;

public class RacingCar {

    private static final int START_LOCATION = 0;
    int location;

    public RacingCar() {
        this.location = START_LOCATION;
    }

    public int findCurrentLocation() {
        return this.location;
    }
}

package racingcar;

public class RacingCar {

    public static final int MINIMUM_NUMBER = 4;

    private String owner;
    private Location location;

    public RacingCar(String owner, Location location) {
        this.owner = owner;
        this.location = location;
    }

    public String getCarLocation() {
        return location.getLocation();
    }

    public void canGo(int number) {
        if (number >= MINIMUM_NUMBER) {
            location.move();
            return;
        }
        location.stop();
    }

    public String getOwner() {
        return owner;
    }
}

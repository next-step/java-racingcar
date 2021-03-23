package racingcar;

public class RacingCar {

    private static final int MINIMUM_NUMBER = 4;
    private String owner;
    private Location location;

    public RacingCar(String owner, Location location) {
        this.owner = owner;
        this.location = location;
    }

    public String getCarLocation() {

        String carLocation = "";

        for (int i = 0; i < location.getLocation(); i++) {
            carLocation += "-";
        }
        return carLocation;
    }

    public void canGo(int number) {
        if (number >= MINIMUM_NUMBER) {
            location.move();
            return;
        }
    }

    public String getOwner() {
        return owner;
    }
}

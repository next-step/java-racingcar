package racingcar.domain;

public class RacingCar {

    private static final int MINIMUM_NUMBER = 4;
    private Owner owner;
    private Location location;

    public RacingCar(Owner owner, Location location) {
        this.owner = owner;
        this.location = location;
    }

    public void move(int number) {
        if (number >= MINIMUM_NUMBER) {
            location = location.move();
        }
    }

    public int getLocation() {
        return location.getLocation();
    }

    public String getOwner() {
        return owner.getName();
    }
}

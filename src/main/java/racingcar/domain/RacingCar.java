package racingcar.domain;

import racingcar.command.NumberType;

public class RacingCar {

    private Owner owner;
    private Location location;

    public RacingCar(String owner, int location) {
        this.owner = new Owner(owner);
        this.location = new Location(location);
    }

    public void move(int number) {
        if (number >= NumberType.FOUR.value()) {
            location = location.move();
        }
    }

    public boolean checkFromLocation(int location) {
        return this.location.checkLocation(location);
    }

    public int getLocation() {
        return location.getLocation();
    }

    public String getOwner() {
        return owner.getName();
    }
}

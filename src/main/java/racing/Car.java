package racing;

import exception.CarLocationException;

public class Car {

    private Location location;

    public Car(Location location) {
        this.location = location;
    }

    public int getLocation() {
        return location.value();
    }

    public Location moveForward() throws CarLocationException {
        return location.plusOne();
    }

}

package racing;

import exception.CarLocationException;

public class Car {

    private String name;
    private Location location;

    public Car(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location.value();
    }

    public Location moveForward() throws CarLocationException {
        return location.plusOne();
    }

}

package step5.domain;

public class Car {

    private final CarName carName;
    private final Location location;

    public Car(final CarName carName) {
        this.location = new Location();
        this.carName = carName;
    }

    public void moveForward() {
        this.location.move();
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public int getLocation() {
        return this.location.getLocation();
    }
}

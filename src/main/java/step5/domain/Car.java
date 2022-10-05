package step5.domain;

public class Car {

    private CarName carName;
    private Location location;

    public Car(CarName carName) {
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

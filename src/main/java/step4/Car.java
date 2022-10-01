package step4;

public class Car {

    private static final int MOVABLE_BOUNDARY = 3;

    private CarName carName;
    private Location location;

    public Car(CarName carName) {
        this.location = new Location();
        this.carName = carName;
    }

    void moveForward(int randomNumber) {
        if (randomNumber > MOVABLE_BOUNDARY) {
            this.location.move();
        }
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public int getLocation() {
        return this.location.getLocation();
    }
}

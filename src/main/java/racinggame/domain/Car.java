package racinggame.domain;

public class Car {

    private String carName;
    int location = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getLocation() {
        return location;
    }

    public void updateLocation(int location) {
        this.location = location;
    }

    public String getCarName() {
        return carName;
    }

}

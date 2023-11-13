package study.race.model;

public class Car {

    private int currentLocation;
    private CarLocationManager carLocationManager;

    public Car() {
        this.carLocationManager = new CarLocationManager();
        this.currentLocation = carLocationManager.initMovingDistance();
    }

    public int getCurrentLocation() {
        return this.currentLocation;
    }

    public void move(int movingDistance) {
        this.currentLocation = carLocationManager.updateLocation(this.currentLocation, movingDistance);
    }
}

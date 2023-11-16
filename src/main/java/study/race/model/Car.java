package study.race.model;

public class Car {

    private String name;
    private int currentLocation;
    private CarLocationManager carLocationManager;

    public Car(String name) {
        this.name = name;
        this.carLocationManager = new CarLocationManager();
        this.currentLocation = carLocationManager.initMovingDistance();
    }

    public String getName() {
        return this.name;
    }
    public int getCurrentLocation() {
        return this.currentLocation;
    }

    public void move(int movingDistance) {
        this.currentLocation = carLocationManager.updateLocation(this.currentLocation, movingDistance);
    }
}

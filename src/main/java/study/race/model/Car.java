package study.race.model;

public class Car {

    private String name;
    private int currentLocation;
    private CarMovingDistance carMovingDistance;

    public Car(String name) {
        this.name = name;
        this.carMovingDistance = new CarMovingDistance();
        this.currentLocation = carMovingDistance.initMovingDistance();
    }

    public String getName() {
        return this.name;
    }
    public int getCurrentLocation() {
        return this.currentLocation;
    }

    public void move(int movingDistance) {
        this.currentLocation = this.carMovingDistance.updateMovingDistance(this.currentLocation, movingDistance);
    }
}

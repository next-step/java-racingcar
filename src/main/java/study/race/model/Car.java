package study.race.model;

public class Car {

    private int currentLocation;
    private Name name;
    private Location location;

    public Car(String name) {
        this.name = new Name(name);
        this.location = new Location();
    }

    public String getName() {
        return this.name.getName();
    }

    public int getLocation() {
        return this.location.getLocation();
    }

    public void move() {
        this.location.updateMovingDistance();
    }
}

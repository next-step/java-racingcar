package racing.domain;


import exception.CarLocationException;

public class Car implements Comparable<Car>{

    private static final int MOVE_FORWARD_CONDITION_NUMBER = 4;
    private static final int MOVE_AMOUNT = 1;
    private String name;
    private Location location;

    public Car(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.name.compareTo(otherCar.getName());
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location.value();
    }

    public boolean isSameLocation(Integer newLocation) {
        return this.getLocation() == newLocation;
    }

    public Location moveForward(int randomNumber) throws CarLocationException {
        if (randomNumber >= MOVE_FORWARD_CONDITION_NUMBER) {
            return location.move(MOVE_AMOUNT);
        }
        return location;
    }

}

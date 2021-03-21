package racingcar.domain;

public class Car {
    private final static int START_LOCATION = 0;
    private final static int MOVE_STRATEGY = 1;

    private int currentLocation;
    private Name name;

    public Car() {
        this.currentLocation = START_LOCATION;
    }

    public Car(int location, Name name) {
        this.currentLocation = location;
        this.name = new Name(name);
    }

    public Car(Name name) {
        this.name = new Name(name);
    }

    public Car(Car car) {
        this.currentLocation = car.currentLocation;
        this.name = car.name;
    }

    public void move(Boolean isMove) {
        if (isMove) {
            this.currentLocation = currentLocation + MOVE_STRATEGY;
        }
    }

    public String getName() {
        return this.name.getName();
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public Boolean bigger(int num) {
        return this.currentLocation > num;
    }

}

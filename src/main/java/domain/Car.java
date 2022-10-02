package domain;

public class Car {

    private final String name;
    private int currentLocation;

    public Car(String name) {
        this.name = name;
        this.currentLocation = 0;
    }

    public void move(boolean isMove) {
        if (isMove) {
            currentLocation += 1;
        }
    }

    public static Car createCarWithName(String carName) {
        return new Car(carName);
    }

    public String getCarName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

}

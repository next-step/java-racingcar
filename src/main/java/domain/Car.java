package domain;

public class Car {

    private static final int MIN_LIMIT_NUMBER = 4;
    private final String name;
    private int currentLocation;

    private Car(String name) {
        this.name = name;
        this.currentLocation = 0;
    }

    public static Car of(String carName) {
        return new Car(carName);
    }

    public void move(int randomNumber) {
        if (isMovingForward(randomNumber)) {
            currentLocation += 1;
        }
    }

    private boolean isMovingForward(int randomNumber) {
        return randomNumber >= MIN_LIMIT_NUMBER;
    }

    public String getCarName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }


}

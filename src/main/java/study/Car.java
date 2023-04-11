package study;

import java.util.Random;

public class Car {
    public int currentLocation;

    public int getCurrentLocation() {
        return currentLocation;
    }

    public boolean canMove(int randomValue) {
        return randomValue >= 4;
    }

    public Car(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void moveForward() {
        this.currentLocation += 1;
    }
}

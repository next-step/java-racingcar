package me.daeho.step3;

public class Car {
    private int currentPosition;

    private Car(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public static Car ready() {
        return new Car(0);
    }

    public int forward() {
        return ++currentPosition;
    }

    public int stop() {
        return currentPosition;
    }
}

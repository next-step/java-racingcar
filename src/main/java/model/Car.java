package model;


public class Car {

    private int currentPosition = 0;

    public void move() {
        this.currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}

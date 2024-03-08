package model;

public class Car {

    private int location;

    public void move(final int randomNumber) {
        if (randomNumber >= 4) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}

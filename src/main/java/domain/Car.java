package domain;


public class Car {
    private static final int MOVABLE_NUMBER = 4;

    private int location;

    public Car() {
        this.location = 0;
    }

    public Car(int location) {
        this.location = location;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVABLE_NUMBER) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}

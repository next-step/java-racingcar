package domain;


public class Car {
    private int location;

    private static final int MOVABLE_NUMBER = 4;
    private static final String LOCATION_SIGN = "-";

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

    public String printLocation() {
        String movement = "";

        for (int i = 0; i < location; i++) {
            movement = movement.concat(LOCATION_SIGN);
        }
        return movement;
    }

    public int getLocation() {
        return location;
    }
}

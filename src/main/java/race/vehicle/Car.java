package race.vehicle;

import java.util.Random;

public class Car {
    private int location;

    Car(int location) {
        this.location = location;
    }

    public void move() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}

package step3;

import java.util.Random;

public class Car {

    private int location = 0;

    public Car(int location) {
        this.location = location;
    }

    public int advanceNumber() {
        Random random = new Random();
        this.location += random.nextInt(10);
        return this.location;
    }

    public int currentLocation() {
        return this.location;
    }

}

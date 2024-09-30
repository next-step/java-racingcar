package race;

import java.util.Random;

public class Car {
    private int carNum;
    private int location;

    Car(int carNum, int location) {
        this.carNum = carNum;
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

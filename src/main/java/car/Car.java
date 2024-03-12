package car;

import java.util.Random;

public class Car {

    private String location;

    public Car() {
        this.location = "";
    }

    public void move(int i) {
        for (; i > 0; i--) {
            move();
        }
    }

    private void move() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            this.location += "-";
        }
    }

    public String getLocation() {
        return location;
    }
}

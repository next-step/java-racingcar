package car;

import java.util.Random;

public class Car {
    private String distance;

    public Car() {
        this.distance = "";
    }

    public String move(int number) {
        if (number < 4) {
            this.distance += "";
            return this.distance;
        }

        this.distance += "-";
        return this.distance;
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public String getDistance() {
        return distance;
    }
}

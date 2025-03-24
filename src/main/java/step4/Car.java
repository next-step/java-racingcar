package step4;

import java.util.Random;

public class Car {
    private int position;
    private Random random;
    public String carName;

    public Car(Random random, String carName) {
        this.position = 1;
        this.random = random;
        this.carName = carName;
    }

    public int getPosition () {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }

    private boolean isMovable () {
        return this.random.nextInt(10) >= 4;
    }

    public void move() {
        if(!isMovable()) return;
        this.position++;
    }
    public String draw() {
        return "-".repeat(this.position);
    }

}

package domain;

import java.util.Random;

public class Car {
    private final int RANDOM_UPPER_BOUND = 10;
    private final int MOVE_THRESHOLD = 4;
    private String name;
    private int status;

    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void move() {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt(RANDOM_UPPER_BOUND) >= 4) {
            this.status++;
        }
    }
}

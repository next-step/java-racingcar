package step3;

import java.util.Random;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final Random random = new Random();

    private int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance() {
        this.distance++;
    }

    public boolean isMove() {
        int number = random.nextInt(10);
        return MOVE_CONDITION <= number;
    }
}
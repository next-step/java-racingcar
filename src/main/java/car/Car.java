package car;

import java.util.Random;

public class Car {
    private int distance = 0;
    private static final int RACING_CONDITION = 4;

    public int getDistance() {
        return distance;
    }

    public void racing() {
        Random random = new Random();
        if(RACING_CONDITION <= random.nextInt(10)) {
            distance++;
        }
    }
}

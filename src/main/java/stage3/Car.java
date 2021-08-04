package stage3;

import java.util.Random;

public class Car {
    private int status;

    public Car() {
        status = 0;
    }

    public int getForwardCondition() {
        Random random = new Random();
        return random.nextInt(10);
    }
}

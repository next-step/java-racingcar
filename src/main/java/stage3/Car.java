package stage3;

import java.util.Random;

public class Car {
    private int status;

    public Car() {
        status = 0;
    }

    public Car(int status) {
        this.status = status;
    }

    public int getForwardCondition() {
        Random random = new Random();
        final int standard = 10;
        return random.nextInt(standard);
    }

    public boolean isForward(int condition) {
        final int threshold = 4;
        return condition >= threshold;
    }

    public int getStatus() {
        return this.status;
    }

    public void forward() {
        this.status++;
    }
}

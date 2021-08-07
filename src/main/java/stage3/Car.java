package stage3;

import java.util.Random;

public class Car {
    private int status;
//    private Random random;

    public Car() {
        status = 0;
    }

    public Car(int status) {
        this.status = status;
//        this.random = new Random();
    }

    public int getForwardCondition() {
        Random random = new Random();
        return random.nextInt(10);
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

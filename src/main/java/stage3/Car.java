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
        return random.nextInt(10);
    }

    public boolean isForward(int condition) {
        if (condition >= 4) return true;
        return false;
    }

    public int getStatus() {
        return this.status;
    }

    public void forward() {
        this.status++;
    }
}

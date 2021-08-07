package stage4;

import java.util.Random;

public class Car {
    private final String name;
    private int status;

    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public Car(String name, int status) {
        this.name = name;
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

    public String getName() {
        return this.name;
    }
}

package stage4;

import java.util.Random;

public class Car {
    private final static int STANDARD = 10;
    private final static int THRESHOLD = 4;

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
        return new Random().nextInt(STANDARD);
    }

    public boolean isForward(int condition) {
        return condition >= THRESHOLD;
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

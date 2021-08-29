package stage4.domain;

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

    public int getStatus() {
        return this.status;
    }

    public String getName() {
        return this.name;
    }

    public int getForwardCondition() {
        return new Random().nextInt(STANDARD);
    }

    private boolean isForward(int condition) {
        return condition >= THRESHOLD;
    }

    private void forward() {
        this.status++;
    }

    public int tryForward(int condition) {
        if (this.isForward(condition)) this.forward();
        return this.getStatus();
    }
}

package step3;

import java.util.Random;

public class Car {
    private static final Random random = new Random();
    private int location = 0;
    private boolean luck = false;

    public void move() {
        if (goOrStay()) {
            goForward();
        }
    }

    private void tossUp() {
        this.luck = random.nextInt(9) > 4;
    }

    public boolean getLuck() {
        return this.luck;
    }

    private boolean goOrStay() {
        tossUp();
        return getLuck();
    }

    public void goForward() {
        location++;
    }

    public int getLocation() {
        return location;
    }

}

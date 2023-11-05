package study.step3;

import java.util.Random;

public class Car {

    private int position = 0;
    private Random random = new Random();

    public Car() {
    }

    public Car(Random random) {
        this.random = random;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (isForwardCondition()) {
            forward();
        }
    }

    private boolean isForwardCondition() {
        return random.nextInt(10) >= 4;
    }

    private void forward() {
        position += 1;
    }

}

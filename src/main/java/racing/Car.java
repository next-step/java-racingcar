package racing;

import java.util.Random;

public class Car {
    private int position = 0;
    private Random random;

    public Car() {
        random = new Random();
    }

    public void move() {
        if (this.random.nextInt(10) <= 4) {
            this.position++;
        }
    }

    public int currentPosition() {
        return this.position;
    }
}

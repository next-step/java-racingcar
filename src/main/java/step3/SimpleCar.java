package step3;

import java.util.Random;

public class SimpleCar {
    public static int RANDOM_BOUND = 10;
    public static int LEAST_MOVABLE_NUM = 4;

    private int position = 0;

    public SimpleCar() {

    }

    private SimpleCar(int position) {
        this.position = position;
    }

    public void run() {
        Random random = new Random();
        if (random.nextInt(RANDOM_BOUND) >= LEAST_MOVABLE_NUM) {
            position += 1;
        }
    }

    public SimpleCar copy() {
        return new SimpleCar(this.getPosition());
    }

    public Integer getPosition() {
        return position;
    }
}

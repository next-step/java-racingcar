package step3;

import java.util.Random;

public class SimpleCar implements Car {
    public static int RANDOM_BOUND = 10;
    public static int LEAST_MOVABLE_NUM = 4;

    private int position = 0;

    public SimpleCar() {

    }

    @Override
    public void run() {
        Random random = new Random();
        if (random.nextInt(RANDOM_BOUND) >= LEAST_MOVABLE_NUM) {
            position += 1;
        }
    }

    @Override
    public Integer getPosition() {
        return position;
    }
}

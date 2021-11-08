package racingcar;

import java.util.Random;

public class CarList {
    private final int RANDOM_RANGE = 10;
    private final int CUTLINE = 4;
    private Random random = new Random();

    private int[] cars;

    public CarList(int count) {
        cars = new int[count];
    }

    public int[] move() {
        for(int i = 0; i < cars.length; i++) {
            cars[i] = canMove()? ++cars[i] : cars[i];
        }
        return this.cars;
    }

    public int length() {
        return this.cars.length;
    }

    private boolean canMove() {
        return random.nextInt(RANDOM_RANGE) > CUTLINE;
    }
}

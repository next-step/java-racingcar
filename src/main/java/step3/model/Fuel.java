package step3.model;

import java.util.Random;

public class Fuel {

    private static final int MAXIMUM_RANDOM_NUMBER = 9;
    private static final int RANDOM_NUMBER_THRESHOLD = 4;
    private final Random gas;

    public Fuel() {
        this.gas = new Random();
    }

    public boolean isMovable() {
        return getRandom() >= RANDOM_NUMBER_THRESHOLD;
    }

    private int getRandom() {
        return gas.nextInt(MAXIMUM_RANDOM_NUMBER);
    }

}

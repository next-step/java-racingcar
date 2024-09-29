package javaracingcar;

import java.util.Random;

public class JavaRacingCar {

    private Random random;

    private static final int RANDOM_VALUE_RANGE = 10;

    public JavaRacingCar(){
        random = new Random();
    }
    protected int random() {
        int randomValue = random.nextInt(RANDOM_VALUE_RANGE);
        return randomValue;
    }
}

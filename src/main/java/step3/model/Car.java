package step3.model;

import java.util.Random;

public class Car {

    private static final Random PICKER = new Random();

    public int getPower(int max) {
        return PICKER.nextInt(max);
    }

    public int getForwardDistance(int power) {
        return (power >= 4) ? 1 : 0;
    }

}

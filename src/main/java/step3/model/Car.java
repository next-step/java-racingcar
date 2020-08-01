package step3.model;

import step3.config.PowerConfig;

import java.util.Random;

public class Car {

    private static final Random PICKER = new Random();

    private int position = 1;

    public int getPower(int max) {
        return PICKER.nextInt(max);
    }

    public int getForwardDistance(int power) {
        return (power >= 4) ? 1 : 0;
    }

    public void move() {
        int power = getPower(PowerConfig.MAX);
        int forwardDistance = getForwardDistance(power);
        position += forwardDistance;
    }

    public int getPosition() {
        return position;
    }

}

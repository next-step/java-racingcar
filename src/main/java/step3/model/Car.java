package step3.model;

import step3.config.PowerConfig;

import java.util.Random;

public class Car {

    private static final Random PICKER = new Random();

    private int position = 1;

    public int getPower() {
        return PICKER.nextInt(PowerConfig.MAX);
    }

    public int getForwardDistance(int power) {
        return (power >= PowerConfig.CONDITION) ? 1 : 0;
    }

    public void move() {
        int power = getPower();
        int forwardDistance = getForwardDistance(power);
        position += forwardDistance;
    }

    public int getPosition() {
        return position;
    }

}

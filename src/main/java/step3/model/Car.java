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
        if(power >= PowerConfig.CONDITION) {
            return 1;
        }
        return 0;
    }

    public Car move(int forwardDistance) {
        position += forwardDistance;
        return this;
    }

    public int getPosition() {
        return position;
    }

}

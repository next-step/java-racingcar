package step3.domain;

import step3.config.PowerConfig;

import java.util.Random;

public class CarRacingRandomPicker {

    private static final Random PICKER = new Random();

    public int getPower() {
        return PICKER.nextInt(PowerConfig.MAX);
    }

    public int getForwardDistance(int power) {
        if(power >= PowerConfig.CONDITION) {
            return 1;
        }
        return 0;
    }

}

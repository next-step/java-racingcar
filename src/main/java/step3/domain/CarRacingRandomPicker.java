package step3.domain;

import step3.config.PowerConfig;

import java.util.Random;

public class CarRacingRandomPicker {

    private static final Random PICKER = new Random();

    public static int getPower() {
        return PICKER.nextInt(PowerConfig.MAX);
    }

    private CarRacingRandomPicker() {
        throw new AssertionError();
    }

}

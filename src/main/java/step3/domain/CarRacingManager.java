package step3.domain;

import step3.config.PowerConfig;

public class CarRacingManager {

    public static int getForwardDistance() {
        int power = CarRacingRandomPicker.getPower();
        if(power >= PowerConfig.CONDITION) {
            return 1;
        }
        return 0;
    }

    private CarRacingManager() {
        throw new AssertionError();
    }

}

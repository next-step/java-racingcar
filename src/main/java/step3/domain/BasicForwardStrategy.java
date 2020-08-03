package step3.domain;

import step3.config.PowerConfig;

import java.util.Random;

public class BasicForwardStrategy implements ForwardStrategy {

    private static final Random PICKER = new Random();

    @Override
    public int calculateForwardDistance() {
        int power = PICKER.nextInt(PowerConfig.MAX);
        if(power >= PowerConfig.CONDITION) {
            return 1;
        }
        return 0;
    }

}

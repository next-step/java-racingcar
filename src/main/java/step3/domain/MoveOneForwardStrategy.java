package step3.domain;

import step3.config.PowerConfig;

import java.util.Random;

public class MoveOneForwardStrategy implements ForwardStrategy {

    private static final Random PICKER = new Random();
    private static final int MOVE = 1;
    private static final int STOP = 0;

    @Override
    public int calculateForwardDistance() {
        int power = PICKER.nextInt(PowerConfig.MAX);
        if(power >= PowerConfig.CONDITION) {
            return MOVE;
        }
        return STOP;
    }

}

package domain;

import java.util.Random;

public class RandomForwardStrategy implements ForwardStrategy {

    private static final Random PICKER = new Random();
    public static final int POWER_MAX = 10;
    public static final int POWER_CONDITION = 4;
    private static final int MOVE = 1;
    private static final int STOP = 0;

    @Override
    public int calculateForwardDistance() {
        int power = PICKER.nextInt(POWER_MAX);
        if(power >= POWER_CONDITION) {
            return MOVE;
        }
        return STOP;
    }

}

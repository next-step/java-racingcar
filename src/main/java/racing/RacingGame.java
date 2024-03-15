package racing;

import java.util.Random;

public class RacingGame {
    public static final int GO_CONDITION = 4;
    public static final int RANDOM_MAX = 10;

    static void carMove(String[] carPosition, int carNumber) {
        if (new Random().nextInt(RANDOM_MAX) >= GO_CONDITION) {
            carPosition[carNumber] += '-';
        }
    }
}

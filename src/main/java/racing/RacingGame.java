package racing;

import java.util.Random;

import static racing.RacingMain.GO_CONDITION;
import static racing.RacingMain.RANDOM_MAX;

public class RacingGame {
    static void carMove(String[] carPosition, int j) {
        if (new Random().nextInt(RANDOM_MAX) >= GO_CONDITION) {
            carPosition[j] += '-';
        }
    }
}

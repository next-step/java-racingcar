package racing.race;

import static racing.Constants.*;

public class RacingChecker {

    public boolean isForward(int num) {
        return num >= MIN_NUM_OF_FORWARD;
    }
}

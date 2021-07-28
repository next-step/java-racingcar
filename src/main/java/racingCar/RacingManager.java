package racingCar;

import sun.jvm.hotspot.utilities.AssertionFailure;

public class RacingManager {
    static private final int THRESHOLD = 4;

    private RacingManager() {
        throw new AssertionFailure();
    }

    static public boolean isMovableNumber(int number){
        return number >= THRESHOLD;
    }

}

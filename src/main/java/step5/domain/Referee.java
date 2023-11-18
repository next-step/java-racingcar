package step5.domain;

import java.util.Random;

public class Referee {
    public static final int CAR_MOBILITY_STANDARD = 5;
    public boolean judgeToMove() {
        Random random = new Random();
        return random.nextInt(10) > CAR_MOBILITY_STANDARD;
    }
}

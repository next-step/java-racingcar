package step3;

import java.util.Random;

public class RacingCondition {
    
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_CONDITION_NUMBER = 4;

    private static Random random = new Random();
    
    public static boolean isMoveForward() {
        return random.nextInt(MAX_RANDOM_NUMBER) >= MOVE_CONDITION_NUMBER;
    } 
    
}

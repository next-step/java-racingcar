package step3;

import java.util.Random;

public class RacingCondition {
    
    private static final int MAX_RANDOM_NUMBER = 10;       //랜덤 최대값 조건
    private static final int MOVE_CONDITION_NUMBER = 4;    //차량의 이동조건
    private static final int FIRST_ROUND_NUMBER = 0;       //첫 라운드 인덱스

    private static Random random = new Random();
    
    public static boolean isFirstRound(int roundIndex) {
        return roundIndex == FIRST_ROUND_NUMBER;
    }
    
    public static boolean isMoveForward() {
        return random.nextInt(MAX_RANDOM_NUMBER) >= MOVE_CONDITION_NUMBER;
    } 
    
}

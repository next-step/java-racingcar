package study.step3;

import java.util.Random;

public class NumberChecker {
    public static boolean checkCondition() {
        Random random = new Random();
        if(random.nextInt(10) >= 4){
            return true;
        }
        return false;
    }
}

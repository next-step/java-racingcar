package racing.domain;

import java.util.Random;

public class Condition {
    static final int VALUE_MIN_NUM = 4;

    public static boolean checkMove(int randomNum) {
        return randomNum >= VALUE_MIN_NUM;
    }

}

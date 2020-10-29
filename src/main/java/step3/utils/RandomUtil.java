package step3.utils;

import java.util.Random;

public class RandomUtil {

    private final static int BOUND_CONDITION = 10;

    private RandomUtil(){}

    public static int generateRandomNumber(){
        return new Random().nextInt(BOUND_CONDITION);
    }
}

package step2.util;

import java.util.Random;

public class Utils {

    private static final int GENERATOR_RANGE = 10;

    public static int createRandomNumber(){
        Random generator = new Random();
        return generator.nextInt(GENERATOR_RANGE);
    }

}

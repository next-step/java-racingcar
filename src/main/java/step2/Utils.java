package step2;

import java.util.Random;

public class Utils {

    private static final int GENERATOR_RANGE = 10;

    static int createRandomNumber(){
        Random generator = new Random();
        return generator.nextInt(GENERATOR_RANGE);
    }

}
